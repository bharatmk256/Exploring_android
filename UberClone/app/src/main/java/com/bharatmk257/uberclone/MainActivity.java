package com.bharatmk257.uberclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.Toast;

import com.parse.ParseInstallation;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    enum State {
        SIGNUP, LOGIN
    }

    private State state;
    private EditText edtUserName, edtPassword, edtDOrP;
    private Button btnSignUpLogin, btnOneTimeLogin;
    private RadioButton rDBPassenger, rDBDriver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseInstallation.getCurrentInstallation().saveInBackground();

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        edtDOrP = findViewById(R.id.edtDOrP);
        btnSignUpLogin = findViewById(R.id.btnSignUpLogIn);
        btnOneTimeLogin = findViewById(R.id.btnOneTimeLogin);

        btnOneTimeLogin.setOnClickListener(this);

        rDBPassenger = findViewById(R.id.rDBPassenger);
        rDBDriver = findViewById(R.id.rDBDriver);

        if (ParseUser.getCurrentUser() != null) {
            ParseUser.logOut();
        }
        state = State.SIGNUP;

        btnSignUpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (state == State.SIGNUP) {
                    if (rDBDriver.isChecked() == false && rDBPassenger.isChecked() == false) {
                        Toast.makeText(MainActivity.this, "Are you driver or a passenger?", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ParseUser appUser = new ParseUser();
                    appUser.setUsername(edtUserName.getText().toString());
                    appUser.setPassword(edtPassword.getText().toString());
                    if (rDBDriver.isChecked()) {
                        appUser.put("as", "Driver");
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signup_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.loginItem:
                if (state == State.SIGNUP) {
                    state = state.LOGIN;
                    item.setTitle("Sign Up");
                    btnSignUpLogin.setText("Log In");
                } else if (state == State.LOGIN) {
                    state = state.SIGNUP;
                    item.setTitle("Log In");
                    btnSignUpLogin.setText("Sign Up");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}
