package com.bharatmk257.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;   // created button
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;  // created Edit text
    private TextView txtGetData;   // created textView

    private Button btnGetAllData;  // created button

    private String allKickBoxers;   // string just for saving data that we got from server and we can show it

    private Button btnNextActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = (Button) findViewById(R.id.btnSave);  // initialised save button with find view
        btnSave.setOnClickListener(SignUp.this);   // onclick method in save btn but i have implemented onclick interface so i did used this method

        edtName = (EditText) findViewById(R.id.edtName);  // find view by id as always :| for edt name
        edtPunchSpeed = (EditText) findViewById(R.id.edtPunchSpeed);   // find view by id as always :| for edt punch speed
        edtPunchPower = (EditText) findViewById(R.id.edtPunchPower);   // find view by id as always :| for edt punch power
        edtKickSpeed = (EditText) findViewById(R.id.edtKickSpeed);   // find view by id as always :| for edt kick speed
        edtKickPower = (EditText) findViewById(R.id.edtKickPower);   // find view by id as always :| for edt kick power

        txtGetData = (TextView) findViewById(R.id.txtGetData);   // find view by id as always :| for textView get data

        btnGetAllData = (Button) findViewById(R.id.btnGetAllData);   // uh crap i don't like this find view by id :| for button view get all data

        btnNextActivity = (Button) findViewById(R.id.btnNextActivity);

        txtGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");  // parse server get query for get data kickBoxer is main key
                parseQuery.getInBackground("e9LUQBbSrS", new GetCallback<ParseObject>() {  // this will get data from background so (whatever) this weard text is object id
                    @Override
                    public void done(ParseObject object, ParseException e) {  // if done so it will tal you if you put popup message hehe cool na

                        if (object != null && e == null) {  // it checks that data that we cot is not null and there is no error if there is we can tell user what just happning e is exception

                            txtGetData.setText(object.get("name") + "-" + "Punch Power : " + object.get("punch_power"));  // setting data to get text that we declared for on click method   main hero for this all thing

                        }     //close everytingooo
                    }//close everyting
                });
            }//close everything
        });

        // let's get all kickBoxer be ready to this complex code

        btnGetAllData.setOnClickListener(new View.OnClickListener() {  // let's get all data with onclick listener
            @Override
            public void onClick(View v) {
                allKickBoxers = "";  // empty string that we have created on top if you don't remember go and see
                ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");  // query parsing query all and main key

//                queryAll.whereGreaterThan("punch_power", 88);  // get all punch power greater then 88
                queryAll.whereGreaterThanOrEqualTo("punch_power",88);  // get all punch power greater then or equal to  88
                queryAll.setLimit(1);  // only one result

                queryAll.findInBackground(new FindCallback<ParseObject>() {  // heavy process so find in background
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {  // if done so lest make sure we have got good data soo make some parseException

                        if (e == null) {  // if exception is null we can go forward and do some work

                            if (objects.size() > 0) {  // if object that we got object = get all data from server   is > 0 we can think we have got good data

                                for (ParseObject kickBoxer : objects) {  // don't be afraid this is just enhanced for loop it will loop till object ends

                                    allKickBoxers = allKickBoxers + kickBoxer.get("name") + "\n";  // and put that got from server in this string  update....it   update....it   update....it   update....it

                                }
                                FancyToast.makeText(SignUp.this, allKickBoxers, FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show(); // toast tada i have used fancy toast library
                            } else {
                                FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();  // exception toast

                            }
                        }

                    }
                });
            }
        });


        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignUp.this,SignUpLoginActivity.class);
                startActivity(intent);

            }
        });




    }


    /*looks like next code is for uploading data to server i mean parse server
     * i think yes let's see
     * i am having dout
     *
     * yes it's confirmed it's for uploading data i was little bit confused
     *
     * let's see what we get */


    @Override
    public void onClick(View v) {

        try {  // first try if error tell us on catch block
            ParseObject kickBoxer = new ParseObject("KickBoxer");  // new object created
            kickBoxer.put("name", edtName.getText().toString());  // from edit text we push to server
            kickBoxer.put("punch_speed", Integer.parseInt(edtPunchSpeed.getText().toString()));  // from edit text we push to server
            kickBoxer.put("punch_power", Integer.parseInt(edtPunchPower.getText().toString()));  // from edit text we push to server
            kickBoxer.put("kick_speed", Integer.parseInt(edtKickSpeed.getText().toString()));  // from edit text we push to server
            kickBoxer.put("kick_power", Integer.parseInt(edtKickPower.getText().toString()));  // from edit text we push to server
            kickBoxer.saveInBackground(new SaveCallback() {  // we push all things in background
                @Override
                public void done(ParseException e) { // find exception if there we can take actions and check data is pushed or not
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, "kick boxer is saved", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();  // toast that data is pushed
                    } else {
                        FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();  // // toast error

                    }
                }
            });
        } catch (Exception e) {
            FancyToast.makeText(SignUp.this, "Invalid Input", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();  // catch block error
        }
    }
}
