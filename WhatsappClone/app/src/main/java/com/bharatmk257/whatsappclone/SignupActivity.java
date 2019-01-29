package com.bharatmk257.whatsappclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtUsrSign, edtEmailSign, edtPassSign;
    Button btnSign, btnActLogSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edtUsrSign = (EditText) findViewById(R.id.edtUsrSign);
        edtEmailSign = (EditText) findViewById(R.id.edtEmailSign);
        edtPassSign = (EditText) findViewById(R.id.edtPassSign);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnActLogSign = (Button) findViewById(R.id.btnActLogSign);

        btnSign.setOnClickListener(SignupActivity.this);
        btnActLogSign.setOnClickListener(SignupActivity.this);

        if (ParseUser.getCurrentUser() != null) {
            transitionUsersActivity();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSign:

                final ParseUser appUser = new ParseUser();
                appUser.setEmail(edtEmailSign.getText().toString());
                appUser.setUsername(edtUsrSign.getText().toString());
                appUser.setPassword(edtPassSign.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(SignupActivity.this, "welcome" + appUser.getUsername(), Toast.LENGTH_SHORT).show();
                            transitionUsersActivity();
                        } else {
                            Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                break;

            case R.id.btnActLogSign:

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void transitionUsersActivity() {
        Intent intent = new Intent(SignupActivity.this, UsersActivity.class);
        startActivity(intent);
        finish();
    }
}
