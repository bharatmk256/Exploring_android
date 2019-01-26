package com.bharatmk257.twitterclone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class TwitterUsers extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> tUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_users);

        setTitle(ParseUser.getCurrentUser().getUsername());

        listView = findViewById(R.id.listView);
        tUsers = new ArrayList<>();
        adapter = new ArrayAdapter(TwitterUsers.this, android.R.layout.simple_list_item_checked, tUsers);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setOnItemClickListener(TwitterUsers.this);

        try {

            ParseQuery<ParseUser> query = ParseUser.getQuery();
            query.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());
            query.findInBackground(new FindCallback<ParseUser>() {
                @Override
                public void done(List<ParseUser> objects, ParseException e) {
                    if (objects.size() > 0 && e == null) {
                        for (ParseUser twitterUser : objects) {
                            tUsers.add(twitterUser.getUsername());
                        }
                        listView.setAdapter(adapter);
                        for (String twitterUser : tUsers) {
                            if (ParseUser.getCurrentUser().getList("fanOf") != null) {
                                if (ParseUser.getCurrentUser().getList("fanOf").contains(twitterUser)) {
                                    listView.setItemChecked(tUsers.indexOf(twitterUser), true);
                                }
                            }
                        }

                    }
                }
            });
        } catch (
                Exception e) {
            e.getStackTrace();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.logoutUserItem:
                ParseUser.getCurrentUser().logOutInBackground(new LogOutCallback() {
                    @Override
                    public void done(ParseException e) {
                        Intent intent = new Intent(TwitterUsers.this, LogIn.class);
                        startActivity(intent);
                        finish();
                    }
                });

                break;
        }
        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

        CheckedTextView checkedTextView = (CheckedTextView) view;

        if (checkedTextView.isChecked()) {
            Toast.makeText(TwitterUsers.this, tUsers.get(position) + " is Followed", Toast.LENGTH_SHORT).show();
            ParseUser.getCurrentUser().add("fanOf", tUsers.get(position));
        } else {
            Toast.makeText(TwitterUsers.this, tUsers.get(position) + " is UnFollowed", Toast.LENGTH_SHORT).show();
            ParseUser.getCurrentUser().getList("fanOf").remove(tUsers.get(position));
            List currentUserFanOfList = ParseUser.getCurrentUser().getList("fanOf");
            ParseUser.getCurrentUser().remove("fanOf");
            ParseUser.getCurrentUser().put("fanOf", currentUserFanOfList);
        }
        ParseUser.getCurrentUser().saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(TwitterUsers.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
