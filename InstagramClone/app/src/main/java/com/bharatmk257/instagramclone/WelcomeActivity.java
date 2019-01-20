package com.bharatmk257.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;

public class WelcomeActivity extends AppCompatActivity {

    TextView txtWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txtWelcome = (TextView) findViewById(R.id.txtWelcome);

        ParseUser.getCurrentUser();

        txtWelcome.setText("Welcome " + ParseUser.getCurrentUser().get("username"));

        findViewById(R.id.btnLogOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser.logOut();
                finish();

            }
        });

    }
}
