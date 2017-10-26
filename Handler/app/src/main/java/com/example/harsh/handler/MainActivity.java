package com.example.harsh.handler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Thread thread;
    Button button;
    ProgressBar progressBar;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar=findViewById(R.id.progressbar1);
        thread=new Thread(new MyThread());
        //will run in the background
        thread.start();

        //this handler is gonna recieve code sent by the
        //MyThread
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);

             }
        };

    }

    class MyThread implements Runnable{

        @Override
        public void run() {

            //obtain a empty reference, and obtain is a
            //static method in Message class

            //we can pass extra arguments and data
            //send Bundle and stuff
            //currently

            for(int i=0;i<100;i++){
                Message message=Message.obtain();
                message.arg1=i;
                handler.sendMessage(message);


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
