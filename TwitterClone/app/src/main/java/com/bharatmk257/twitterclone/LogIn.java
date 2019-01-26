package com.bharatmk257.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsrlogIn, edtPassLogIn;
    private Button btnLogIn, btnSignUpActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        edtUsrlogIn = (EditText) findViewById(R.id.edtUsrlogIn);
        edtPassLogIn = (EditText) findViewById(R.id.edtPassLogIn);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnSignUpActivity = (Button) findViewById(R.id.btnSignUpActivity);

        btnSignUpActivity.setOnClickListener(LogIn.this);
        btnLogIn.setOnClickListener(LogIn.this);

        if (ParseUser.getCurrentUser() != null) {
            transitionToTwitterUsers();
//            ParseUser.logOut();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSignUpActivity:
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.btnLogIn:
                ParseUser.logInInBackground(edtUsrlogIn.getText().toString(), edtPassLogIn.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            Toast.makeText(LogIn.this, "welcome Back " + user.getUsername(), Toast.LENGTH_SHORT).show();
                            transitionToTwitterUsers();
                        } else {
                            Toast.makeText(LogIn.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
        }

    }

    public void transitionToTwitterUsers() {
        Intent intent = new Intent(LogIn.this, TwitterUsers.class);
        startActivity(intent);
        finish();
    }
}
