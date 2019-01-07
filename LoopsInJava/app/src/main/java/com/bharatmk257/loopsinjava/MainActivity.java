package com.bharatmk257.loopsinjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    private String helloWorldValue = "";
    int multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        int counter = 1;
//        String hello = "";
//
//        while (counter <= 10){
//            hello= hello + "Hello world counter" + counter + "\n";
//            counter = counter+1;
//        }
//
//        text1=findViewById(R.id.text1);
//        text1.setText(hello);

//        for (int counter = 0; counter < 20; counter = counter + 1){
//
//            Log.i("MyTag","Hello World Number" + counter);
//
//            helloWorldValue = helloWorldValue +
//                    "Hello World Number" + (counter+1) +"\n";
//
//        }
        text1=findViewById(R.id.text1);
//        text1.setText(helloWorldValue);


    }

    public void clicked(View click){
        EditText numm = (EditText)findViewById(R.id.editText);
        int number = Integer.parseInt(numm.getText().toString());
        String helloWorldValue = "";

        for (int i =1; i<=10;i++){
            multi = number * i;
            helloWorldValue = helloWorldValue + number + " * " + i + " = " + multi +"\n" ;
        }

        text1.setText(helloWorldValue);
    }

}
