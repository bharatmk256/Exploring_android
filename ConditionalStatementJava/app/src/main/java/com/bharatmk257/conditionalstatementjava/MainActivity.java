package com.bharatmk257.conditionalstatementjava;

import android.renderscript.Sampler;
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


        boolean myLaptopIsMac= false;

        if (myLaptopIsMac == true){
            Log.i("ISMAC","Yes it is true");
        }else if (myLaptopIsMac != true){
            Log.i("ISMAC","No it is not true");
        }

    }
    public void isClicked(View getno){

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        TextView textView = (TextView) findViewById(R.id.textView);

        int text1 = Integer.parseInt(editText1.getText().toString());
        int text2 = Integer.parseInt(editText2.getText().toString());

        if (text1>text2){
            textView.setText(String.valueOf("First number is grater than second"));
        }else if (text1<text2){
            textView.setText(String.valueOf("Second number is grater than first"));
        }else{
            textView.setText(String.valueOf("equal"));
        }

    }
}
