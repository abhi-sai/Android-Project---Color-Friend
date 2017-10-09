package org.opencv.samples.colorblobdetect;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoColorDetector(View view)
    {
        Intent i = new Intent(MainActivity.this,ColorBlobDetectionActivity.class);
        startActivity(i);
    }

    public void gotoColorBlindTest(View view)
    {
        Intent i = new Intent(MainActivity.this,ColorBlindTest.class);
        startActivity(i);
    }

    private int PICK_IMAGE_REQUEST = 1;

    public void gotoDaltonize(View view)
    {
        Intent intent = new Intent();

        // Show only images, no videos or anything else
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        // Always show the chooser (if there are multiple options available)
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Log.d("ImageHandler","Intent works");
            Uri uri = data.getData();
            Intent i = new Intent(MainActivity.this,Daltonize.class);
            i.setData(uri);
            startActivity(i);
        }
    }

}
