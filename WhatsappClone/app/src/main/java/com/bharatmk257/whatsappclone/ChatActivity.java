package com.bharatmk257.whatsappclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView chatListView;
    private ArrayList<String> chatsList;
    private ArrayAdapter adapter;
    private String selectedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        selectedUser = getIntent().getStringExtra("selectedUser");

        setTitle(selectedUser);

        Toast.makeText(ChatActivity.this, "chat with " + selectedUser, Toast.LENGTH_SHORT).show();

        findViewById(R.id.btnSend).setOnClickListener(ChatActivity.this);
        chatListView = findViewById(R.id.chatListView);
        chatsList = new ArrayList();
        adapter = new ArrayAdapter(ChatActivity.this, android.R.layout.simple_list_item_1, chatsList);
        chatListView.setAdapter(adapter);


//        ParseQuery<ParseObject>

    }

    @Override
    public void onClick(View view) {

        final EditText edtMessage = findViewById(R.id.edtSend);
        ParseObject chat = new ParseObject("Chat");
        chat.put("waSender", ParseUser.getCurrentUser().getUsername());
        chat.put("waTargetRecipient", selectedUser);
        chat.put("waMessage", edtMessage.getText().toString());
        chat.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                Toast.makeText(ChatActivity.this, ParseUser.getCurrentUser().getUsername() + "sent to " + selectedUser, Toast.LENGTH_SHORT).show();
                chatsList.add(ParseUser.getCurrentUser().getUsername() + ": " + edtMessage.getText().toString());
                adapter.notifyDataSetChanged();
                edtMessage.setText("");
            }
        });

    }
}
