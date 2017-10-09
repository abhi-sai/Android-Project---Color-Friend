package org.opencv.samples.colorblobdetect;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.opencv.core.CvType.CV_32FC3;
import static org.opencv.core.CvType.CV_64FC1;
import static org.opencv.core.CvType.CV_64FC3;
import static org.opencv.core.CvType.CV_8UC3;

public class Daltonize extends Activity {

    private int MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daltonize);
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i("OpenCV", "OpenCV loaded successfully");
                    Uri uri = getIntent().getData();
                    if (ContextCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.READ_CONTACTS)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Daltonize.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE);
                    }

                    InputStream stream = null;
                    try {
                        stream = getContentResolver().openInputStream(uri);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
                    bmpFactoryOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;

                    Bitmap bmp = BitmapFactory.decodeStream(stream, null, bmpFactoryOptions);

                    Mat ImageMat = new Mat();
                    Utils.bitmapToMat(bmp, ImageMat);
                    Mat ImageMatRGB = new Mat();
                    Imgproc.cvtColor(ImageMat, ImageMatRGB, Imgproc.COLOR_RGBA2RGB); //8UC3
                    ImageMatRGB.convertTo(ImageMatRGB,CV_32FC3,1/255.0);
                    ImageMatRGB.convertTo(ImageMatRGB,CV_64FC3);

                    //Transformation matrix for Deuteranope (a form of red/green color deficit)
                    double lms2lmsd1[] = {1,0,0,0.494207,0,1.24827,0,0,1};
                    Mat lms2lmsd = new Mat(3,3,CV_64FC1);
                    lms2lmsd.put(0,0,lms2lmsd1);

                    //Transformation matrix for Protanope (another form of red/green color deficit)
                    double lms2lmsp1[] = {0,2.02344,-2.52581,0,1,0,0,0,1};
                    Mat lms2lmsp = new Mat(3,3,CV_64FC1);
                    lms2lmsp.put(0,0,lms2lmsp1);

                    //Transformation matrix for Tritanope (a blue/yellow deficit - very rare)
                    double lms2lmst1[] = {1,0,0,0,1,0,-0.395913,0.801109,0};
                    Mat lms2lmst = new Mat(3,3,CV_64FC1);
                    lms2lmst.put(0,0,lms2lmst1);

                    //Colorspace transformation matrices
                    double rgb2lms1[] = {17.8824,43.5161,4.11935,3.45565,27.1554,3.86714,0.0299566,0.184309,1.46709};
                    Mat rgb2lms = new Mat(3,3,CV_64FC1);
                    rgb2lms.put(0,0,rgb2lms1);
                    Mat lms2rgb = rgb2lms.inv();

                    //Daltonize image correction matrix
                    double err2mod1[] = {0,0,0,0.7,1,0,0.7,0,1};
                    Mat err2mod = new Mat(3,3,CV_64FC1);
                    err2mod.put(0,0,err2mod1);

                    //CHANGE ACCORDING TO TYPE OF COLOR BLINDNESS
                    Mat lms2lms_deficit = lms2lmsd;

                    Mat LMS = new Mat(ImageMatRGB.rows(),ImageMatRGB.cols(),CvType.CV_64FC3);
                    Mat _LMS = LMS;
                    Mat _RGB = LMS;
                    Mat ERR = LMS;
                    int i,j;

                    double actRGBVal[];
                    double tempRGB[];
                    Mat lmsval = new Mat(1,1,CV_64FC3);
                    Mat lmsResVec = new Mat();
                    Mat actRGBVec = new Mat(3,1,CV_64FC1);
                    try {
                        for (i = 0; i < ImageMatRGB.rows(); i++) {
                            for (j = 0; j < ImageMatRGB.cols(); j++) {
                                actRGBVal = ImageMatRGB.get(i, j);
                                actRGBVec.put(0, 0, actRGBVal);
                                Core.gemm(rgb2lms, actRGBVec, 1, new Mat(), 0, lmsResVec, 0);
                                double lmsvaldata[] = {lmsResVec.get(0,0)[0],lmsResVec.get(1,0)[0],lmsResVec.get(2,0)[0]};
                                LMS.put(i,j,lmsvaldata);
                                }
                        }
                    }
                    catch (Exception e){
                        Log.d("ImageHandler","Error rgb to lms conversion! " + e.getMessage());
                    }

                    try {
                        for (i = 0; i < ImageMatRGB.rows(); i++) {
                            for (j = 0; j < ImageMatRGB.cols(); j++) {
                                actRGBVal = LMS.get(i, j);
                                actRGBVec.put(0, 0, actRGBVal);
                                Core.gemm(lms2lms_deficit, actRGBVec, 1, new Mat(), 0, lmsResVec, 0);
                                double lmsvaldata[] = {lmsResVec.get(0,0)[0],lmsResVec.get(1,0)[0],lmsResVec.get(2,0)[0]};
                                _LMS.put(i,j,lmsvaldata);
                            }
                        }
                    }
                    catch (Exception e){
                        Log.d("ImageHandler","Error rgb to lms conversion! " + e.getMessage());
                    }

                    try {
                        for (i = 0; i < ImageMatRGB.rows(); i++) {
                            for (j = 0; j < ImageMatRGB.cols(); j++) {
                                actRGBVal = _LMS.get(i,j);
                                actRGBVec.put(0, 0, actRGBVal);
                                Core.gemm(lms2rgb, actRGBVec, 1, new Mat(), 0, lmsResVec, 0);
                                double lmsvaldata[] = {lmsResVec.get(0,0)[0],lmsResVec.get(1,0)[0],lmsResVec.get(2,0)[0]};
                                _RGB.put(i,j,lmsvaldata);
                            }
                        }
                    }
                    catch (Exception e){
                        Log.d("ImageHandler","Error rgb to lms conversion! " + e.getMessage());
                    }

                    Mat error = new Mat(ImageMatRGB.rows(),ImageMatRGB.cols(), CV_64FC3);

                    Core.subtract(ImageMatRGB,_RGB,error,new Mat(),CV_64FC3);

                    try {
                        for (i = 0; i < ImageMatRGB.rows(); i++) {
                            for (j = 0; j < ImageMatRGB.cols(); j++) {
                                actRGBVal = error.get(i,j);
                                actRGBVec.put(0, 0, actRGBVal);
                                Core.gemm(err2mod, actRGBVec, 1, new Mat(), 0, lmsResVec, 0);
                                double lmsvaldata[] = {lmsResVec.get(0,0)[0],lmsResVec.get(1,0)[0],lmsResVec.get(2,0)[0]};
                                ERR.put(i,j,lmsvaldata);
                            }
                        }
                    }
                    catch (Exception e){
                        Log.d("ImageHandler","Error rgb to lms conversion! " + e.getMessage());
                    }

                    Mat dtpn = new Mat(ImageMatRGB.rows(),ImageMatRGB.cols(), CV_64FC3);

                    Core.add(ERR,ImageMatRGB,dtpn,new Mat(),CV_64FC3);

                    dtpn.convertTo(dtpn,CV_32FC3);
                    dtpn.convertTo(dtpn,CV_8UC3,255.0);


                    try {
                        for (i = 0; i < ImageMatRGB.rows(); i++) {
                            for (j = 0; j < ImageMatRGB.cols(); j++) {
                                actRGBVal = dtpn.get(i, j);
                                actRGBVal[0] = (actRGBVal[0] > 0) ? actRGBVal[0] : 0;
                                actRGBVal[0] = (actRGBVal[0] < 255) ? actRGBVal[0] : 255;
                                actRGBVal[1] = (actRGBVal[1] > 0) ? actRGBVal[1] : 0;
                                actRGBVal[1] = (actRGBVal[1] < 255) ? actRGBVal[1] : 255;
                                actRGBVal[2] = (actRGBVal[2] > 0) ? actRGBVal[2] : 0;
                                actRGBVal[2] = (actRGBVal[2] < 255) ? actRGBVal[2] : 255;
                                dtpn.put(i,j, actRGBVal);
                            }
                        }
                    }
                    catch (Exception e){
                        Log.d("ImageHandler","Error rgb to lms conversion! " + e.getMessage());
                    }

                    try {
                        Bitmap bm2 = Bitmap.createBitmap(dtpn.cols(), dtpn.rows(), Bitmap.Config.ARGB_8888);
                        Utils.matToBitmap(dtpn, bm2);

                        // find the imageview and draw it!
                        ImageView iv2 = (ImageView) findViewById(R.id.dal_image_view);
                        iv2.setImageBitmap(bm2);
                    }
                    catch(Exception e){
                        Log.d("ImageHandler","Not working! " + e.getMessage());
                    }
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d("OpenCV", "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d("OpenCV", "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

}

