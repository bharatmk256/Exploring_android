package com.bharatmk257.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private EditText edtUsrSignUp, edtEmailSignUp, edtPassSignUp;
    private Button btnSignUp, btnLogInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtUsrSignUp = (EditText) findViewById(R.id.edtUsrSignUp);
        edtEmailSignUp = (EditText) findViewById(R.id.edtEmailSignUp);
        edtPassSignUp = (EditText) findViewById(R.id.edtPassSignUp);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnLogInActivity = (Button) findViewById(R.id.btnLogInActivity);


        btnLogInActivity.setOnClickListener(SignUp.this);
        btnSignUp.setOnClickListener(SignUp.this);


        if (ParseUser.getCurrentUser() != null) {
            transitionToTwitterUsers();
//            ParseUser.logOut();
        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSignUp:
                final ParseUser appUser = new ParseUser();
                appUser.setEmail(edtEmailSignUp.getText().toString());
                appUser.setUsername(edtUsrSignUp.getText().toString());
                appUser.setPassword(edtPassSignUp.getText().toString());

                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(SignUp.this, "welcome " + appUser.getUsername(), Toast.LENGTH_LONG).show();
                            transitionToTwitterUsers();
                        } else {
                            Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
                break;
            case R.id.btnLogInActivity:
                Intent intent = new Intent(SignUp.this, LogIn.class);
                startActivity(intent);
                break;
        }


    }

    public void transitionToTwitterUsers() {
        Intent intent = new Intent(SignUp.this, TwitterUsers.class);
        startActivity(intent);
        finish();
    }
}
