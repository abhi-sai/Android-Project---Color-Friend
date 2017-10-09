package org.opencv.samples.colorblobdetect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ColorBlindTest extends Activity {

    int count = 1;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_blind_test);
    }

    public void StartColorBlindTest(View view)
    {
        setContentView(R.layout.color_blind_test_plates);
        final TextView ishiharaPlate = (TextView) findViewById(R.id.ishihara_plate);
        final ImageView testPlate = (ImageView) findViewById(R.id.plate_image_view);
        final TextView diagnosisText = (TextView) findViewById(R.id.diagnosis_text);
        final Button nextButton = (Button) findViewById(R.id.next_button);


        testPlate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageName = "plate"+count+"r";
                testPlate.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

                diagnosisText.setText(getResources().getIdentifier(imageName, "string", getPackageName()));
                diagnosisText.setVisibility(View.VISIBLE);

                nextButton.setVisibility(View.VISIBLE);
                nextButton.setClickable(true);

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;

                if(count<25) {
                    imageName = "plate" + count;
                    ishiharaPlate.setText("Ishihara Plate " + count);

                    testPlate.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));

                    diagnosisText.setVisibility(View.GONE);
                    nextButton.setVisibility(View.GONE);
                    nextButton.setClickable(false);
                }
                else{
                    Intent i = new Intent(ColorBlindTest.this,MainActivity.class);
                    startActivity(i);
                }

            }
        });

    }

}
