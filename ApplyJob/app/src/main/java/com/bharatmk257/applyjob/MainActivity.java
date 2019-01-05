package com.bharatmk257.applyjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText birthyear,androidDev;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        birthyear = findViewById(R.id.age_edit);
        androidDev = findViewById(R.id.experience_edit);
        results = findViewById(R.id.results);
    }
    public void takeTest(View tested){

        int year = Integer.parseInt(birthyear.getText().toString());
        String dev = androidDev.getText().toString();

        if (year <= 1999 && (dev.equals("Yes")||dev.equals("yes"))){
            results.setText("Congratulaitons You are selected for job");
        }else {
            results.setText("Sorry You are not aligeble for this job");
        }

    }
}
