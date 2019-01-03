package com.bharat.bharatmk257.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challange);
    }

    public void buttonIsClicked(View buttonView){

//        TextView textView = findViewById(R.id.text_1);
//        Log.i("TAG", textView.getText().toString());

//        EditText name = findViewById(R.id.edt_name);
//        Log.i("TTT",name.getText().toString());

//        EditText phoneNo = findViewById(R.id.edt_number);
//        Log.i("NNN",phoneNo.getText().toString());


        /*
        * toast show some text with this methods
        * first is toast class
        * make text methods
        * activity name with this
        * add some string to show toast
        * define length
        * .show method to show toast*/
//        Toast.makeText(MainActivity.this,
//                "Your name is: " + name.getText().toString() +"\n Your phone no is: " + phoneNo.getText().toString(),
//                Toast.LENGTH_SHORT).show();

        ImageView imageView = (ImageView)findViewById(R.id.image_first);
        imageView.setImageResource(R.drawable.wall);

    }

}
