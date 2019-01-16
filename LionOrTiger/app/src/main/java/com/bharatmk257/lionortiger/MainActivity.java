package com.bharatmk257.lionortiger;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player {

        ONE, TWO, No

    }

    /**
     * enum is an data type that we define also we have to define what input can it accept
     */

    Player currentPlayer = Player.ONE;
    /**
     * we have define value of current player
     */


    Player[] playerChoices = new Player[9];
    /**
     * create array fo player choices
     */

    int[][] winnerRowsAndColumns = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    /**
     * created 2 diamention array that checks who is winner
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerChoices[0] = Player.No;
        playerChoices[1] = Player.No;
        playerChoices[2] = Player.No;
        playerChoices[3] = Player.No;
        playerChoices[4] = Player.No;
        playerChoices[5] = Player.No;
        playerChoices[6] = Player.No;
        playerChoices[7] = Player.No;
        playerChoices[8] = Player.No;

    }

    public void imageViewIsTapped(View imageView) {
        /*
         * created imageViewIsTapped method
         * */

        ImageView tappedImageView = (ImageView) imageView;  // this is casting
        /*
         * imageView is tapped check
         * */

        tappedImageView.setTranslationX(-2000);
        /*
         * make this image to other position so we can animate this image
         * */

        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());
        /*
         * get int of tapped image tag
         * */

        playerChoices[tiTag] = currentPlayer;
        /*
         * check player choice and set it to array called playerChoices
         * */


        if (currentPlayer == Player.ONE) {
            tappedImageView.setImageResource(R.drawable.lion);
            currentPlayer = Player.TWO;
        } else if (currentPlayer == Player.TWO) {
            tappedImageView.setImageResource(R.drawable.tiger);
            currentPlayer = Player.ONE;
        }
        /*
         * check which player is playing and change player every time
         * */


        tappedImageView.animate().translationXBy(2000).alpha(1).
                rotation(3600).setDuration(1000);
        /*
         * after tapping it animates every time
         * */

        Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();
        /*toast tag of tapped image*/


        for (int[] winnerColumns : winnerRowsAndColumns) {

            if (playerChoices[winnerColumns[0]]
                    == playerChoices[winnerColumns[1]]
                    && playerChoices[winnerColumns[1]]
                    == playerChoices[winnerColumns[2]]
                    && playerChoices[winnerColumns[0]]
                    != Player.No) {
                Toast.makeText(this,"we have winner",Toast.LENGTH_SHORT).show();
            }

        }


    }
}
