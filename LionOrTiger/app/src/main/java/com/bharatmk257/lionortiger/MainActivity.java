package com.bharatmk257.lionortiger;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player {

        ONE, TWO

    }

    Player currentPlayer = Player.ONE;


    Player[] playerChoices = new Player[9];

    int[][] winnerRowsAndColumns = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void imageViewIsTapped(View imageView) {

        ImageView tappedImageView = (ImageView) imageView;  // this is casting

        tappedImageView.setTranslationX(-2000);

        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        playerChoices[tiTag] = currentPlayer;


        if (currentPlayer == Player.ONE) {
            tappedImageView.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if (currentPlayer == Player.TWO) {
            tappedImageView.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }


        tappedImageView.animate().translationXBy(2000).alpha(1).
                rotation(3600).setDuration(1000);

        Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();

    }
}
