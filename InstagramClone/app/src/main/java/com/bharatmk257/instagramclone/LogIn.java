package com.bharatmk257.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class LogIn extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserLog, edtPasswordLog;
    private Button btnLogIn;
    private TextView txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        edtUserLog = (EditText) findViewById(R.id.edtUserLog);
        edtPasswordLog = (EditText) findViewById(R.id.edtPasswordLog);

        edtPasswordLog.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER &&
                        event.getAction() == KeyEvent.ACTION_DOWN) {
                    onClick(btnLogIn);
                }
                return false;
            }
        });

        btnLogIn = (Button) findViewById(R.id.btnLogIn);

        txtSignUp = (TextView) findViewById(R.id.txtSignUp);

        if (ParseUser.getCurrentUser() != null) {
            transitionToSocialMediaActivity();
        }

        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logInInBackground(edtUserLog.getText().toString(), edtPasswordLog.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser user, ParseException e) {
                                if (user != null && e == null) {
                                    FancyToast.makeText(LogIn.this, "hello " + user.getUsername() + " welcome back", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                    transitionToSocialMediaActivity();
                                } else {
                                    FancyToast.makeText(LogIn.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                                }
                            }
                        });

            }
        });

//        if (ParseUser.getCurrentUser() != null) {
//            ParseUser.logOut();
//        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLogIn:

                break;
        }
    }

    public void rootLayoutTapped(View view) {

        try {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private void transitionToSocialMediaActivity() {
        Intent intent = new Intent(LogIn.this, SocialMediaActivity.class);
        startActivity(intent);
        finish();
    }
}
