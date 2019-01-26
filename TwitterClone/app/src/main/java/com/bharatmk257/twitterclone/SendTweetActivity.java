package com.bharatmk257.twitterclone;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class SendTweetActivity extends AppCompatActivity {

    EditText edtTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_tweet);

        setTitle("Let's send tweet");


        edtTweet = (EditText) findViewById(R.id.edtTweet);
    }

    public void sendTweet(View view) {

        ParseObject parseObject = new ParseObject("MyTweet");
        parseObject.put("tweet", edtTweet.getText().toString());
        parseObject.put("user", ParseUser.getCurrentUser().getUsername());
        final ProgressDialog progressDialog = new ProgressDialog(SendTweetActivity.this);
        progressDialog.setMessage("Twittering...");
        progressDialog.show();
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SendTweetActivity.this, "done", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SendTweetActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


        });
        progressDialog.dismiss();
    }
}
