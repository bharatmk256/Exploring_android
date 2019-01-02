package com.bharat.bharatmk257.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonIsClicked(View buttonView){

//        TextView textView = findViewById(R.id.text_1);
//        Log.i("TAG", textView.getText().toString());

//        EditText editText = findViewById(R.id.edt_name);
//        Log.i("TTT",editText.getText().toString());

        EditText editNum = findViewById(R.id.edt_number);
        Log.i("NNN",editNum.getText().toString());
    }

}
