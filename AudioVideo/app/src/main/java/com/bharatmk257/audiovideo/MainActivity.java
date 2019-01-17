package com.bharatmk257.audiovideo;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnCompletionListener {


    //UI components
    private VideoView myVideoView; // initialize VideoView to myVideoView
    private Button btnPlayVideo; // initialize Button to btnPlayVideo
    private MediaController mediaController;


    private Button btnPlayMusic;
    private Button btnPauseMusic;
    private MediaPlayer mediaPlayer;
    private SeekBar volumeSeekBar;
    private SeekBar moveSeekBar;
    private Timer timer;

    private AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myVideoView = (VideoView) findViewById(R.id.myVideoView); // finding video view with R.id and instanciate to myVideoView
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);  // finding btn with R.id and instanciate to btnPlayVideo

        btnPlayMusic = (Button) findViewById(R.id.btnPlayMusic);
        btnPauseMusic = (Button) findViewById(R.id.btnPauseMusic);

        volumeSeekBar = findViewById(R.id.seekBarVolume);
        moveSeekBar = findViewById(R.id.seekBarMove);

        mediaController = new MediaController(MainActivity.this);

        btnPlayVideo.setOnClickListener(MainActivity.this);
        btnPlayMusic.setOnClickListener(MainActivity.this);
        btnPauseMusic.setOnClickListener(MainActivity.this);

        mediaPlayer = MediaPlayer.create(this, R.raw.sunflow);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maximumVolumeOfUserDevice = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currenVolumeOfUserDevice = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        volumeSeekBar.setMax(maximumVolumeOfUserDevice);
        volumeSeekBar.setProgress(currenVolumeOfUserDevice);

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {

                    //Toast.makeText(MainActivity.this,Integer.toString(progress),Toast.LENGTH_SHORT).show();

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        moveSeekBar.setOnSeekBarChangeListener(MainActivity.this);
        moveSeekBar.setMax(mediaPlayer.getDuration());

        mediaPlayer.setOnCompletionListener(MainActivity.this);



    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()) {

            case R.id.btnPlayVideo:

                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sunflower);

                myVideoView.setVideoURI(videoUri);

                myVideoView.setMediaController(mediaController);
                mediaController.setAnchorView(myVideoView);

                myVideoView.start();

                break;
            case R.id.btnPlayMusic:

                mediaPlayer.start();
                timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        moveSeekBar.setProgress(mediaPlayer.getCurrentPosition());

                    }
                }, 0,500);


                break;
            case R.id.btnPauseMusic:

                mediaPlayer.pause();
                timer.cancel();

                break;

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekBarMove:

                if (fromUser) {

//                    Toast.makeText(MainActivity.this, Integer.toString(progress), Toast.LENGTH_SHORT).show();

                    mediaPlayer.seekTo(progress);

                    break;

                }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        mediaPlayer.pause();

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        mediaPlayer.start();

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

        timer.cancel();

        Toast.makeText(this, "Music done", Toast.LENGTH_SHORT).show();

    }
}
