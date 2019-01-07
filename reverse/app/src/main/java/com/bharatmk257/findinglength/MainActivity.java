package com.bharatmk257.findinglength;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


/*this app takes input from user and reverse value and prints value in display*/


public class MainActivity extends AppCompatActivity {
    private EditText text; //define edit text
    private TextView textView;  //define textView
    private String reversedWord = ""; // text that save reversed text

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text1); // define id of text view
        text = findViewById(R.id.editText);  // define id of edit text


        String[] sports = new  String[4];
        sports[0] = "judo";
        sports[1] = "karate";
        sports[2] = "tennis";
        sports[3] = "cricket";

        for (String like : sports){
            Log.i("favourite sports is",like);
        }

    }


    public void clickclick (View view) {

        reversedWord = ""; // we put string because when we click we can set string empty
        String word = text.getText().toString(); // getting text from edit text
        char[] wordArry = word.toCharArray(); // converting String that got from edit text to char array so we can reverse

        for (int index = wordArry.length - 1; index >= 0; index--){
            /*1. int index == word array .length -1 "means we get length of array of word and we know array start from 0 so we decressed -1 from it"
            * 2. index >=0 "means if index start from last index because of length so we get last index if it's less than or equl to 0 loop will be finished
            * 3. we decressd one from it so we can get next to the last index and prevent from infinite loop*/

            Log.i("MyTag", wordArry[index] + "");
            reversedWord = reversedWord + wordArry[index] + ""; //we put index of array one by one in this string value
        }

        textView.setText(reversedWord); // we printed this string on canvass

    }
}
