package com.bharatmk257.whatsappclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsrLog, edtPassLog;
    private Button btnLog, btnActSignLog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsrLog = (EditText) findViewById(R.id.edtUsrLog);
        edtPassLog = (EditText) findViewById(R.id.edtPassLog);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnActSignLog = (Button) findViewById(R.id.btnActSignLog);
        btnLog.setOnClickListener(LoginActivity.this);
        btnActSignLog.setOnClickListener(LoginActivity.this);


        if (ParseUser.getCurrentUser() != null) {
            transitionUsersActivity();
        }


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnLog:
                ParseUser.logInInBackground(edtUsrLog.getText().toString(), edtPassLog.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {

                            Toast.makeText(LoginActivity.this, "welcome" + user.getUsername(), Toast.LENGTH_SHORT).show();
                            transitionUsersActivity();

                        } else {

                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

                break;
            case R.id.btnActSignLog:

                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();

                break;
        }
    }

    private void transitionUsersActivity() {
        Intent intent = new Intent(LoginActivity.this, UsersActivity.class);
        startActivity(intent);
        finish();
    }
}
