package com.bharatmk257.socialmediafirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText edtEmail, edtUsername, edtPassword;
    private Button btnSignUp, btnSignIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        mAuth = FirebaseAuth.getInstance();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtEmail.getText().toString().equals("") && edtPassword.getText().toString().equals("")  && edtUsername.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill the details", Toast.LENGTH_SHORT).show();
                } else {
                    signUp();
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (edtEmail.getText().toString().equals("") && edtPassword.getText().toString().equals("")  && edtUsername.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill the details", Toast.LENGTH_SHORT).show();
                } else {
                    signIn();
                }
            }
        });


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            transitionToSocialMediaActivity();

        }
    }

    private void signUp() {


        mAuth.createUserWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "SignUp Success", Toast.LENGTH_LONG).show();

                    FirebaseDatabase.getInstance().getReference().child("my_users")
                            .child(task.getResult().getUser().getUid())
                            .child("username").setValue(edtUsername.getText().toString());

                    transitionToSocialMediaActivity();

                } else {

                    Toast.makeText(MainActivity.this, "SignUp Failed", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    private void signIn() {

        mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(MainActivity.this, "SignIn Success", Toast.LENGTH_LONG).show();
                    transitionToSocialMediaActivity();

                } else {

                    Toast.makeText(MainActivity.this, "SignIn Failed", Toast.LENGTH_LONG).show();

                }

            }
        });

    }

    private void transitionToSocialMediaActivity() {

        Intent intent = new Intent(MainActivity.this, SocialMediaActivity.class);

        startActivity(intent);

    }

}
