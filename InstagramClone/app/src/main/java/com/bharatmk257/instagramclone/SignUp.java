package com.bharatmk257.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;
    private TextView txtGetData;

    private Button btnGetAllData;

    private String allKickBoxers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(SignUp.this);

        edtName = (EditText) findViewById(R.id.edtName);
        edtPunchSpeed = (EditText) findViewById(R.id.edtPunchSpeed);
        edtPunchPower = (EditText) findViewById(R.id.edtPunchPower);
        edtKickSpeed = (EditText) findViewById(R.id.edtKickSpeed);
        edtKickPower = (EditText) findViewById(R.id.edtKickPower);

        txtGetData = (TextView) findViewById(R.id.txtGetData);

        btnGetAllData = (Button) findViewById(R.id.btnGetAllData);

        txtGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("e9LUQBbSrS", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {

                        if (object != null && e == null){

                            txtGetData.setText(object.get("name") + "-" + "Punch Power : " + object.get("punch_power"));

                        }

                    }
                });
            }
        });


        btnGetAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                allKickBoxers = "";

                ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");
                queryAll.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {

                        if (e == null){

                            if (objects.size() > 0){

                                for (ParseObject kickBoxer : objects) {

                                    allKickBoxers = allKickBoxers + kickBoxer.get("name") + "\n";


                                }
                                FancyToast.makeText(SignUp.this, allKickBoxers, FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,true).show();
                            } else {
                                FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_SHORT, FancyToast.SUCCESS,true).show();

                            }
                        }

                    }
                });

            }
        });


    }

    @Override
    public void onClick(View v) {

        try {
        ParseObject kickBoxer = new ParseObject("KickBoxer");
        kickBoxer.put("name",edtName.getText().toString());
        kickBoxer.put("punch_speed",Integer.parseInt(edtPunchSpeed.getText().toString()));
        kickBoxer.put("punch_power",Integer.parseInt(edtPunchPower.getText().toString()));
        kickBoxer.put("kick_speed",Integer.parseInt(edtKickSpeed.getText().toString()));
        kickBoxer.put("kick_power",Integer.parseInt(edtKickPower.getText().toString()));
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
//                    Toast.makeText(SignUp.this,"kick boxer is saved",Toast.LENGTH_SHORT).show();
                    FancyToast.makeText(SignUp.this,"kick boxer is saved",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                } else {
                    FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                }
            }
        });
        }catch (Exception e){
            FancyToast.makeText(SignUp.this,"Invalid Input",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
        }
    }
}
