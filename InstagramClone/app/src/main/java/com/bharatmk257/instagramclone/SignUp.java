package com.bharatmk257.instagramclone;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        txtSignIn = (TextView) findViewById(R.id.txtSignIn);

        final ProgressDialog progressDialog = new ProgressDialog(this);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        } else {
                            FancyToast.makeText(SignUp.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();
                        }
                        progressDialog.dismiss();

                    }
                });

            }
        });

        txtSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.logOut();
        }

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnSignUp:


                break;
        }
    }
}
