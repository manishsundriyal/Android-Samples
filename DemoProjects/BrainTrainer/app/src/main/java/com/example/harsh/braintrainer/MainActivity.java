package com.example.harsh.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timerTextView;
    TextView pointsTextView;
    TextView sumTextView;
    RelativeLayout relativeLayout;
    Button playAgainButton;
    ArrayList<Integer> answers=new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score=0;
    int numberOfQuestions=0;

    public void playAgain(View view){
        score=0;
        numberOfQuestions=0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuestion();
        new CountDownTimer(30100,1000) {
            @Override
            public void onTick(long l) {

                timerTextView.setText(String.valueOf(l/1000) + "s");

            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                resultTextView.setText("YOUR SCORE : " + Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
                playAgainButton.setVisibility(View.VISIBLE);

            }
        }.start();


    }



    public void generateQuestion(){
        Random rand=new Random();
        int a=rand.nextInt(21),b=rand.nextInt(21);

        TextView sumTextView=(TextView) findViewById(R.id.sumTextView);
        sumTextView.setText(Integer.toString(a) + " + " +Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);
        answers.clear();
        int incorrectAnswer;
        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer)
                answers.add(a+b);
            else{
                incorrectAnswer=rand.nextInt(41);
                while(incorrectAnswer==a+b){
                    incorrectAnswer=rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }


    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
                score++;
            resultTextView.setText("Correct!");

        }else {
            resultTextView.setText("Incorrect!");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestion();
    }



    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
        relativeLayout.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pointsTextView=(TextView) findViewById(R.id.pointsTextView);
        relativeLayout=(RelativeLayout) findViewById(R.id.gameRelativeLayout);
        timerTextView=(TextView) findViewById(R.id.timerTextView);
        playAgainButton=(Button)findViewById(R.id.playAgainButton);
        resultTextView=(TextView) findViewById(R.id.resultTextView);
        sumTextView=(TextView) findViewById(R.id.sumTextView);
        startButton=(Button) findViewById(R.id.startButton);
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
    }
}
