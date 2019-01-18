package com.bharatmk257.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class SignUp extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void helloWorldTapped(View view){

        ParseObject kickBoxer = new ParseObject("KckBoxer");
        kickBoxer.put("name","john");
        kickBoxer.put("punch_speed",300);
        kickBoxer.put("punch_power",500);
        kickBoxer.put("kick_power",500);
        kickBoxer.put("kick_power",500);
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(SignUp.this,"kick boxer is saved",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
