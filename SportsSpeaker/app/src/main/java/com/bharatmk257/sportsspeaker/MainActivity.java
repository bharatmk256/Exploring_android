package com.bharatmk257.sportsspeaker;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imgBoxing, imgKickBoxing, imgJudo, imgKarate, imgAikido, imgTaekwondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBoxing = (ImageButton) findViewById(R.id.imgBoxing);
        imgKickBoxing = (ImageButton) findViewById(R.id.imgKickBoxing);
        imgJudo = (ImageButton) findViewById(R.id.imgJudo);
        imgKarate = (ImageButton) findViewById(R.id.imgKarate);
        imgAikido = (ImageButton) findViewById(R.id.imgAikido);
        imgTaekwondo = (ImageButton) findViewById(R.id.imgTaekwondo);

        imgBoxing.setOnClickListener(MainActivity.this);
        imgKickBoxing.setOnClickListener(MainActivity.this);
        imgJudo.setOnClickListener(MainActivity.this);
        imgKarate.setOnClickListener(MainActivity.this);
        imgAikido.setOnClickListener(MainActivity.this);
        imgTaekwondo.setOnClickListener(MainActivity.this);


    }

    @Override
    public void onClick(View imageButtonView) {

        switch (imageButtonView.getId()) {
            case R.id.imgBoxing:

                playSportName(imgBoxing.getTag().toString());

                break;
            case R.id.imgKickBoxing:

                playSportName(imgKickBoxing.getTag().toString());

                break;
            case R.id.imgJudo:

                playSportName(imgJudo.getTag().toString());

                break;
            case R.id.imgKarate:

                playSportName(imgKarate.getTag().toString());

                break;
            case R.id.imgAikido:

                playSportName(imgAikido.getTag().toString());

                break;
            case R.id.imgTaekwondo:

                playSportName(imgTaekwondo.getTag().toString());

                break;
        }

    }

    private void playSportName(String sportName) {

        MediaPlayer sportPlayer = MediaPlayer.create(
                MainActivity.this, getResources().getIdentifier(
                        sportName, "raw", getPackageName()));

        sportPlayer.start();

    }
}
