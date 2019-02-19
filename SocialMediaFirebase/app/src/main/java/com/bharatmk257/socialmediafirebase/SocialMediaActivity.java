package com.bharatmk257.socialmediafirebase;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;

public class SocialMediaActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private ImageView postImageView;
    private Button btnCreatePost;
    private EditText edtDes;
    private ListView usersListView;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);

        mAuth = FirebaseAuth.getInstance();

        postImageView = (ImageView) findViewById(R.id.postImageView);
        btnCreatePost = (Button) findViewById(R.id.btnCreatePost);
        edtDes = (EditText) findViewById(R.id.edtDes);
        usersListView = (ListView) findViewById(R.id.usersListView);


        postImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.logoutItem:

                logout();
                break;

        }

        return super.onOptionsItemSelected(item);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        logout();
    }

    private void logout() {

        mAuth.signOut();
        finish();
    }


    private void selectImage() {

        if (Build.VERSION.SDK_INT < 23) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1000);
        } else if (Build.VERSION.SDK_INT >= 23) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);

            } else {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1000);

            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            selectImage();
        }

    }
}
