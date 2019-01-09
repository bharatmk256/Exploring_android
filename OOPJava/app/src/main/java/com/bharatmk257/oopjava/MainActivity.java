package com.bharatmk257.oopjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnThrowJab;

    Boxer myBoxer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThrowJab = (Button) findViewById(R.id.btnThrowJab);


        KickBoxer myKickBoxer = new KickBoxer(2,700,20,30,500);
        myBoxer = new Boxer(0,400,900);

        /* 1. refering :- boxer class and type
           2. my boxer :- name of boxer variable
           3. new :- now assigning new boxer into my boxer
           4. Boxer() :- object of type boxer "()" <-- this means it's class we can pass somthing in it also   */


        //Log.i("MYTAG",myBoxer.toString());
        /* in java classes are object type
         *  to get address on this object in heap memory
         *  so we have to convert into to string we can also use +""  to convert it into string
         *  we will get hash code of this object's  address */


        // Log.i("MYTAG",myKickBoxer.toString());


        // myBoxer.numberOfGloves = 900;
        //Log.i("MYTAG","punch speed: " + myBoxer.punchSpeed + "punch power: " + myBoxer.punchPower);

        //myKickBoxer.kickPower = 500;
        //myKickBoxer.punchPower = 700;
        //Log.i("MYTAG","kick speed: " + myKickBoxer.kickPower + "punch power: " + myKickBoxer.punchPower);

        //new Boxer(); //creates new object of type boxer in the memory

        //Log.i("MYTAG","kick speed: " + (new Boxer().punchPower = 700) + ""); // creates new boxer objects and prints value
        //Log.i("MYTAG","kick speed: " + (new Boxer()) + ""); // creates new boxer objects and prints hash code

        myBoxer.setNumberOfGloves(2);  // we have defined setter method on boxer class so here is the code how to set value

        myBoxer.getNumberOfGloves(); // we will get number of gloves

        Log.i("MYTAG", myBoxer.getNumberOfGloves() + "");

        //   new KickBoxer(); /* () <-- it's constructor when we create new object of specific type it's called constructor
       // constructor can be empty or it may ask for pass the value */


        myBoxer.setStamina(40);

        Boxer newBoxer = new Boxer(4,50,2);

//        Log.i("MyTag","New Boxer Stamina" + newBoxer.stamina);    //simple method to get data without getter and setter

        // newBoxer.stamina = 70;  //simple method to set data without getter and setter

        Boxer.setStamina(20); //this value shared so when we set this value to 900 it will set 900 on all stamina objects

        Log.i("MyTag", "All Boxers Stamina " + myBoxer.getStamina());



        myBoxer.throwJab();

    }


    public void throwJabIsClicked(View buttonView) {

        Toast.makeText(MainActivity.this,myBoxer.throwJab(),Toast.LENGTH_LONG).show();

    }

    public void throwKickIsClicked(View buttonView) {

        Toast.makeText(MainActivity.this,myBoxer.throwKick(),Toast.LENGTH_LONG).show();

    }

}
