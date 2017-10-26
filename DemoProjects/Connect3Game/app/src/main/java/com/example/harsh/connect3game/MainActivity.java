package com.example.harsh.connect3game;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;//0 represents yellow and 1 represents red

    int[] gameState={2,2,2,2,2,2,2,2,2};

    int [][] winningPositions={{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8},{2,4,6}};

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        counter.setTranslationY(-10000f);
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2) {
            gameState[tappedCounter] = activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
            } else {
                counter.setImageResource(R.drawable.red);
            }
            activePlayer = 1 - activePlayer;
            counter.animate().translationYBy(10000f).setDuration(50);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[0]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {
                    String winner = "Red";
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                    }

                    GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                    winnerMessage.setText(winner + " won the game.");
                    LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                    gridLayout.setVisibility(View.INVISIBLE);



                }else{
                    boolean gameIsOver=true;
                    for(int counterState:gameState){
                        if(counterState==2)
                            gameIsOver=false;
                    }
                    if(gameIsOver){

                        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage);
                        winnerMessage.setText("Its a draw !");
                        LinearLayout layout = (LinearLayout) findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                        gridLayout.setVisibility(View.INVISIBLE);

                    }
                }
            }
        }
    }

        public void playAgain(View view){
            LinearLayout linearLayout=(LinearLayout) findViewById(R.id.playAgainLayout);
            linearLayout.setVisibility(View.INVISIBLE);
            activePlayer=0;
            for(int i=0;i<gameState.length;i++){
                gameState[i]=2;
            }
            GridLayout gridLayout=(GridLayout) findViewById(R.id.gridLayout);
            gridLayout.setVisibility(View.VISIBLE);

            for (int i=0;i<gridLayout.getChildCount();i++){
                ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
