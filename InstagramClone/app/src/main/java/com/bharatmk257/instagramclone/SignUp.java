package com.bharatmk257.instagramclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUserSign, edtEmailSign, edtPasswordSign;
    private Button btnSignUp;
    private TextView txtSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtUserSign = (EditText) findViewById(R.id.edtUserSign);
        edtEmailSign = (EditText) findViewById(R.id.edtEmailSign);
        edtPasswordSign = (EditText) findViewById(R.id.edtPasswordSign);

        edtPasswordSign.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER &&
                        event.getAction() == KeyEvent.ACTION_DOWN) {

                    onClick(btnSignUp);

                }

                return false;
            }
        });

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        txtSignIn = (TextView) findViewById(R.id.txtSignIn);

        final ProgressDialog progressDialog = new ProgressDialog(this);

        if (ParseUser.getCurrentUser() != null) {
            transitionToSocialMediaActivity();
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtUserSign.getText().toString().equals("") || edtPasswordSign.getText().toString().equals("") || edtEmailSign.getText().toString().equals("")) {

                    FancyToast.makeText(SignUp.this, "Please Fill Blanks", FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                } else {

                    final ParseUser appUser = new ParseUser();
                    appUser.setEmail(edtEmailSign.getText().toString());
                    appUser.setUsername(edtUserSign.getText().toString());
                    appUser.setPassword(edtPasswordSign.getText().toString());

                    progressDialog.setMessage("Signing up " + edtUserSign.getText().toString());
                    progressDialog.show();

                    appUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {

                            if (e == null) {
                                FancyToast.makeText(SignUp.this, "welcome " + appUser.getUsername(), FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                transitionToSocialMediaActivity();
                            } else {
                                FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                            }
                            progressDialog.dismiss();

                        }
                    });

                }
            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSignUp:

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
        Intent intent = new Intent(SignUp.this, SocialMediaActivity.class);
        startActivity(intent);
    }


}
