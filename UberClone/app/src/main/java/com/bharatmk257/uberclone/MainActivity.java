package com.bharatmk257.uberclone;

import android.content.Intent;
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

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    public void onClick(View v) {

        if (edtDOrP.getText().toString().equals("Driver") || edtDOrP.getText().toString().equals("Passenger")) {

            if (ParseUser.getCurrentUser() == null) {
                ParseAnonymousUtils.logIn(new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null && e == null) {
                            Toast.makeText(MainActivity.this, "We have anonymus user", Toast.LENGTH_SHORT).show();

                            user.put("as", edtDOrP.getText().toString());

                            user.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {
                                    transitionToPassengerActivity();
                                    transitionToDriverRequestListActivity();
                                }
                            });
                        }
                    }
                });
            }

        } else if (edtDOrP.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Are you driver or passenger?", Toast.LENGTH_SHORT).show();
        }
    }

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
            transitionToPassengerActivity();
            transitionToDriverRequestListActivity();
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
                    } else if (rDBPassenger.isChecked()) {
                        appUser.put("as", "Passenger");
                    }

                    appUser.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(MainActivity.this, "Signed up", Toast.LENGTH_SHORT).show();
                                transitionToPassengerActivity();
                                transitionToDriverRequestListActivity();
                            } else {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                } else if (state == state.LOGIN) {

                    ParseUser.logInInBackground(edtUserName.getText().toString(), edtPassword.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null && e == null) {
                                Toast.makeText(MainActivity.this, "user is logged in", Toast.LENGTH_SHORT).show();
                                transitionToPassengerActivity();
                                transitionToDriverRequestListActivity();
                            } else {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
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


    private void transitionToPassengerActivity() {
        if (ParseUser.getCurrentUser() != null) {
            if (ParseUser.getCurrentUser().get("as").equals("Passenger")) {
                Intent intent = new Intent(MainActivity.this, PassengerActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }

    private void transitionToDriverRequestListActivity() {

        if (ParseUser.getCurrentUser() != null) {
            if (ParseUser.getCurrentUser().get("as").equals("Driver")) {
                Intent intent = new Intent(MainActivity.this, DriverRequestListActivity.class);
                startActivity(intent);
                finish();
            }
        }

    }

}
