package com.bharat.bharatmk257.variableswithjava;

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

       /* int age = 10;
        long data = 20;
        byte price = 20;

        float userScore = 20f;
        double computerRam = 20;

        boolean isThere = true;

        String name = "Bharat"; //String is object it's class

        char letterA = 'a'; //when char combines it becomes string

        Log.i("MYTAG",age+"");*/

        //priorities of operators () */% +-

    }
    public void Bharat(View view) {
        EditText edit1 = (EditText)findViewById(R.id.editText1);

        EditText edit2 = (EditText)findViewById(R.id.editText2);

        int a = Integer.parseInt(edit1.getText().toString()) *
                Integer.parseInt(edit2.getText().toString());

        TextView textView = (TextView)findViewById(R.id.text1);
        textView.setText(a+"");
    }



}
