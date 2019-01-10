package com.bharatmk257.interfacejava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnThrowFasterJab;
    private Button btnThrowFasterCross;
    private Button btnThrowFasterHook;
    private Button btnThrowFasterUppercut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThrowFasterJab = (Button) findViewById(R.id.btnThrowJab);
        btnThrowFasterCross = (Button) findViewById(R.id.btnThrowCross);
        btnThrowFasterHook = (Button) findViewById(R.id.btnThrowHook);
        btnThrowFasterUppercut = (Button) findViewById(R.id.btnThrowUppercut);

        final Boxer boxerA = new Boxer();
        final KickBoxer boxerB = new KickBoxer();

        boxerA.throwJab();
        boxerA.throwCross();
        boxerA.throwHook();
        boxerA.throwUppercut();

        boxerB.throwJab();
        boxerB.throwCross();
        boxerB.throwHook();
        boxerB.throwUppercut();

        btnThrowFasterJab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,boxerA.throwJab(),Toast.LENGTH_LONG).show();
            }
        });

        btnThrowFasterCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,boxerA.throwCross(),Toast.LENGTH_LONG).show();
            }
        });

        btnThrowFasterHook.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Toast.makeText(MainActivity.this,boxerA.throwHook(),Toast.LENGTH_LONG).show();
            }
        });

        btnThrowFasterUppercut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,boxerA.throwUppercut(),Toast.LENGTH_LONG).show();
            }
        });




    }
}
