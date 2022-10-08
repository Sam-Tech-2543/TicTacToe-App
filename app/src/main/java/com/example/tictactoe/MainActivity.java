package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global Vars
    String playerName;
    Boolean gameState = true;
    int moves = 0;
    int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = "X";
    }

    public void dropIn(View view) {
        ImageView img = (ImageView) view;

        int t = Integer.parseInt(img.getTag().toString());

        if (board[t] == 0 && gameState) {
            if (playerName == "X") {
                img.setImageResource(R.drawable.x);
                playerName = "O";
                board[t] = 1;
                moves++;
            } else {
                img.setImageResource(R.drawable.o);
                playerName = "X";
                board[t] = 2;
                moves++;
            }
            img.animate().alpha(1).setDuration(750);
        }

        for (int i = 0; i < 8; i++) {
            if (board[winningPos[i][0]] == 1 && board[winningPos[i][1]] == 1 && board[winningPos[i][2]] == 1) {
                Toast.makeText(this, "Player X won the Game!", Toast.LENGTH_SHORT).show();

                gameState = false;
            }
            if (board[winningPos[i][0]] == 2 && board[winningPos[i][1]] == 2 && board[winningPos[i][2]] == 2) {
                Toast.makeText(this, "Player O won the Game!", Toast.LENGTH_SHORT).show();

                gameState = false;
            }
            if (moves == 9) {
                Toast.makeText(this, "Game Drawn!", Toast.LENGTH_SHORT).show();
                moves = 0;
            }
        }

    }

    public void clearBoard(View view) {
        board[0] = 0;
        board[1] = 0;
        board[2] = 0;
        board[3] = 0;
        board[4] = 0;
        board[5] = 0;
        board[6] = 0;
        board[7] = 0;
        board[8] = 0;

        ImageView img1 = (ImageView) findViewById(R.id.imageView1);
        img1.animate().alpha(0);
        ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        img2.animate().alpha(0);
        ImageView img3 = (ImageView) findViewById(R.id.imageView3);
        img3.animate().alpha(0);
        ImageView img4 = (ImageView) findViewById(R.id.imageView4);
        img4.animate().alpha(0);
        ImageView img5 = (ImageView) findViewById(R.id.imageView5);
        img5.animate().alpha(0);
        ImageView img6 = (ImageView) findViewById(R.id.imageView6);
        img6.animate().alpha(0);
        ImageView img7 = (ImageView) findViewById(R.id.imageView7);
        img7.animate().alpha(0);
        ImageView img8 = (ImageView) findViewById(R.id.imageView8);
        img8.animate().alpha(0);
        ImageView img9 = (ImageView) findViewById(R.id.imageView9);
        img9.animate().alpha(0);

        playerName = "X";
        gameState = true;
        moves = 0;
    }
}