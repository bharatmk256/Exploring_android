package com.bharatmk257.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUpLoginActivity extends AppCompatActivity {

    private EditText edtUserNameSignUp, edtUserNameSignIn, edtPasswordSignUp, edtPasswordSignIn;
    private Button btnSignUp, btnSignIn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);

        edtUserNameSignIn = (EditText) findViewById(R.id.edtUserNameSignIn);
        edtUserNameSignUp = (EditText) findViewById(R.id.edtUserNameSignUp);
        edtPasswordSignIn = (EditText) findViewById(R.id.edtPasswordSignIn);
        edtPasswordSignUp = (EditText) findViewById(R.id.edtPasswordSignUp);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ParseUser appUser = new ParseUser();
                appUser.setUsername(edtUserNameSignUp.getText().toString());
                appUser.setPassword(edtPasswordSignUp.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            FancyToast.makeText(SignUpLoginActivity.this, appUser.get("username") + " is signed up successfully", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();

                            Intent intent = new Intent(SignUpLoginActivity.this,WelcomeActivity.class);
                            startActivity(intent);

                        } else {
                            FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }
                    }
                });

            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParseUser.logInInBackground(edtUserNameSignIn.getText().toString(), edtPasswordSignIn.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null && e == null) {

                            FancyToast.makeText(SignUpLoginActivity.this, "Welcome " + user.get("username") + " :)", FancyToast.LENGTH_SHORT, FancyToast.SUCCESS, true).show();

                            Intent intent = new Intent(SignUpLoginActivity.this,WelcomeActivity.class);
                            startActivity(intent);

                        } else {

                            FancyToast.makeText(SignUpLoginActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }

                    }
                });


            }
        });

    }
}
