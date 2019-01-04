package com.bharatmk257.arrandcollections;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        int [] myIntNumbers = {1,2,3,4,5,6,7,8,9,10};
//
//        int firstNumberOfArray = myIntNumbers[9];
//        Log.i("FoundIt",String.valueOf(firstNumberOfArray + ""));
//        Log.i("FoundIt",String.valueOf(myIntNumbers.length-1));
//        Log.i("FoundIt",String.valueOf(myIntNumbers[myIntNumbers.length-1]));
//        Log.i("FoundIt",String.valueOf(myIntNumbers[10]));//array numbers out of bound exception
//        Log.i("FoundIt",myIntNumbers + ""); //finds address of array on heap memory

        /*array are not capable to add and remove
        * we cant't co array.add and array.remove */


        ArrayList myFavAnimals = new ArrayList();
        myFavAnimals.add("Lion");
        myFavAnimals.add("Tiger");
        myFavAnimals.add("Leopard");
        Log.i("FoundIt",myFavAnimals.get(0)+"");

        myFavAnimals.add("Fish");
        myFavAnimals.remove(2);

        Log.i("FoundIt",myFavAnimals.get(2)+"");

        TextView text = (TextView) findViewById(R.id.hel);
        text.setText(myFavAnimals.toString());

        myFavAnimals.add(2);

        Log.i("FoundIt",myFavAnimals.toString());


//        ArrayList<String> mobileNames =  new ArrayList<>();//for data type we have to define data type on < > brackets
//        mobileNames.add("samsung");

        HashMap computers = new HashMap();
        computers.put(4,"whattt"); // hashmap has to input first is key and second is value

        Log.i("whatIsIt",String.valueOf(computers.get(4))); // we can access data of hashmap using key

        computers.put("laptop","macboook");
        computers.put("laptop2","surface");
        computers.put("laptop3","chromebook");

        Log.i("ohhhh",String.valueOf(computers.toString())); // HashMap is not organised output so we can get any data first or last
        Log.i("ohhhh",String.valueOf(computers.size()));

        computers.remove("laptop2");
        Log.i("ohhhh",String.valueOf(computers.toString())); // HashMap is not organised output so we can get any data first or last
        Log.i("ohhhh",String.valueOf(computers.size()));

        Log.i("whatIsIt",String.valueOf(computers.get(9))); // it will return null but not gonna crashhhh


        String [] sportsName = new String[5]; // spacified size of array so we can't add more than this
        sportsName [0] = "boxing"; //we have to specify which index we are using for putting value
        sportsName [1] = "5kg"; //we have to specify which index we are using for putting value
        sportsName [3] = "10kg"; //we have to specify which index we are using for putting value
        sportsName [4] = "20kg"; //we have to specify which index we are using for putting value
        //sportsName [5] = "40kg"; //it shows error



    }
}