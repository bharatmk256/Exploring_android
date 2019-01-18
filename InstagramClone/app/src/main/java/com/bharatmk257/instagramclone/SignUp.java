package com.bharatmk257.instagramclone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave;
    private EditText edtName, edtPunchSpeed, edtPunchPower, edtKickSpeed, edtKickPower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnSave = (Button) findViewById(R.id.btnSave);
        edtName = (EditText) findViewById(R.id.edtName);
        edtPunchSpeed = (EditText) findViewById(R.id.edtPunchSpeed);
        edtPunchPower = (EditText) findViewById(R.id.edtPunchPower);
        edtKickSpeed = (EditText) findViewById(R.id.edtKickSpeed);
        edtKickPower = (EditText) findViewById(R.id.edtKickPower);

        btnSave.setOnClickListener(SignUp.this);

    }

    @Override
    public void onClick(View v) {

        try {



        ParseObject kickBoxer = new ParseObject("KickBoxer");
        kickBoxer.put("name",edtName.getText().toString());
        kickBoxer.put("punch_speed",Integer.parseInt(edtPunchSpeed.getText().toString()));
        kickBoxer.put("punch_power",Integer.parseInt(edtPunchPower.getText().toString()));
        kickBoxer.put("kick_speed",Integer.parseInt(edtKickSpeed.getText().toString()));
        kickBoxer.put("kick_power",Integer.parseInt(edtKickPower.getText().toString()));
        kickBoxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
//                    Toast.makeText(SignUp.this,"kick boxer is saved",Toast.LENGTH_SHORT).show();
                    FancyToast.makeText(SignUp.this,"kick boxer is saved",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                } else {
                    FancyToast.makeText(SignUp.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();

                }
            }
        });
        }catch (Exception e){
            FancyToast.makeText(SignUp.this,"Invalid Input",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
        }
    }
}
