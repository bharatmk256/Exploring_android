package com.example.bharatmk257.mypet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void dateGet (View view){
        EditText editDateText = (EditText)findViewById(R.id.edt_day);
        int year = Calendar.getInstance().get(Calendar.YEAR)- Integer.parseInt(editDateText.getText().toString());
        TextView textDateView = (TextView)findViewById(R.id.bday);
        textDateView.setText(year + "");

    }
}
