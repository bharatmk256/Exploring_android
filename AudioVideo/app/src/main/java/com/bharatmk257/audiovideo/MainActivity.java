package com.bharatmk257.audiovideo;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, MediaPlayer.OnCompletionListener {  // ugh.... many interfaces are implemented right such a stupid things


    //UI components
    private VideoView myVideoView; // initialize VideoView to myVideoView
    private Button btnPlayVideo; // initialize Button to btnPlayVideo
    private MediaController mediaController; // media controller that control video play pause and other buttons to video


    private Button btnPlayMusic;  // button play music from xml
    private Button btnPauseMusic;  // button pause music form xml
    private MediaPlayer mediaPlayer;  // mediaplayer object that play audio and video also control video and audio
    private SeekBar volumeSeekBar;  // volume seek bar from xml
    private SeekBar moveSeekBar;  // audio move seek bar from xml
    private Timer timer;  // timer get time of audio and stuff so we can apply time to seek bar

    private AudioManager audioManager;  // AudioManager provides access to volume and ringer mode control


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myVideoView = (VideoView) findViewById(R.id.myVideoView); // finding video view with R.id and instanciate to myVideoView
        btnPlayVideo = (Button) findViewById(R.id.btnPlayVideo);  // finding btn with R.id and instanciate to btnPlayVideo

        btnPlayMusic = (Button) findViewById(R.id.btnPlayMusic);  // finding play music button with R.id from xml
        btnPauseMusic = (Button) findViewById(R.id.btnPauseMusic);  // finding play pause button with R.id from xml

        volumeSeekBar = findViewById(R.id.seekBarVolume);  // finding Volume seek bar with R.id from xml
        moveSeekBar = findViewById(R.id.seekBarMove);  // finding move audio seek bar with R.id from xml

        mediaController = new MediaController(MainActivity.this); // new media instanciate mediacontroller

        btnPlayVideo.setOnClickListener(MainActivity.this); // onclick listener to play video button main activity this because we have implemented onclick on class
        btnPlayMusic.setOnClickListener(MainActivity.this);  // onclick listener to play music button main activity this because we have implemented onclick on class
        btnPauseMusic.setOnClickListener(MainActivity.this);  // onclick listener to pause video button main activity this because we have implemented onclick on class

        mediaPlayer = MediaPlayer.create(this, R.raw.sunflow);  // created musicplayer and added song to this
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);  // get service of audio manager

        int maximumVolumeOfUserDevice = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  // get maximum volume of device and set it to int variable
        int currenVolumeOfUserDevice = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);  // get current volume of device and set it to int variable

        volumeSeekBar.setMax(maximumVolumeOfUserDevice);  // set maximum volume of device from int variable and set it to seek bar
        volumeSeekBar.setProgress(currenVolumeOfUserDevice);  // set current volume of device from int variable and set it to seek bar

        volumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {  // on seek bar change listener override method that we have implemented in class
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {

                    //Toast.makeText(MainActivity.this,Integer.toString(progress),Toast.LENGTH_SHORT).show();

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);  // set volume from seek bar

                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // blah blah blah

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {  // blah blah blah blah

            }
        });


        moveSeekBar.setOnSeekBarChangeListener(MainActivity.this);  // set on seek bar change listener to this
        moveSeekBar.setMax(mediaPlayer.getDuration());  // getting audio duration and set it to seek bar

        mediaPlayer.setOnCompletionListener(MainActivity.this);  // check if audio completed method :/


    }

    @Override
    public void onClick(View buttonView) {

        switch (buttonView.getId()) {

            case R.id.btnPlayVideo:

                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sunflower); // getting video uri

                myVideoView.setVideoURI(videoUri);  // setting video uri to video view

                myVideoView.setMediaController(mediaController);  //setting video controller to video view
                mediaController.setAnchorView(myVideoView);  // setting video controller to video view...... i think i am right :/

                myVideoView.start();  // let's start video :)

                break;
            case R.id.btnPlayMusic:

                mediaPlayer.start();  // let's play audio
                timer = new Timer();  // start timer so we can set to seek bar
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        moveSeekBar.setProgress(mediaPlayer.getCurrentPosition());  // move seek bar to current position of timer of audio

                    }
                }, 0, 500); // start timer in milli seconds ,,,, and upgrade seek bar in milli seconds


                break;
            case R.id.btnPauseMusic:

                mediaPlayer.pause();  // pause music :(
                timer.cancel();  // we have to cancel timer background process

                break;

        }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekBarMove:

                if (fromUser) {

//                    Toast.makeText(MainActivity.this, Integer.toString(progress), Toast.LENGTH_SHORT).show();

                    mediaPlayer.seekTo(progress);  // so when we seek seek bar audio starts from there

                    break;

                }
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        mediaPlayer.pause();  // lambi baat he samaj me nahi aayegi

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        mediaPlayer.start();  // lambi baat he samaj me nahi aayegi

    }

    @Override
    public void onCompletion(MediaPlayer mp) {

        timer.cancel();  // when music end timer stops

        Toast.makeText(this, "Music done", Toast.LENGTH_SHORT).show();

    }
}
