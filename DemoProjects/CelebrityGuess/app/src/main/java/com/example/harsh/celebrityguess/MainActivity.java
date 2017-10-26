package com.example.harsh.celebrityguess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

        ArrayList<String> celebUrls= new ArrayList<String >();
        int chosenCeleb=0;
        ArrayList<String> celebNames=new ArrayList<String >();
    int locationOfCorrectAnswer=0;
    String [] answers=new String [4];
    ImageView imageView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;


    public void celebChosen(View view){
        if(view.getTag().equals(Integer.toString(locationOfCorrectAnswer)))
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(this, "Wrong! It was " + celebNames.get(chosenCeleb), Toast.LENGTH_SHORT).show();
        }
        generateQuestion();
    }

    public class ImageDownloader extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url=new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                Bitmap myBitMap= BitmapFactory.decodeStream(inputStream);
                return myBitMap;


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    public void generateQuestion(){

        Random rand=new Random();
        chosenCeleb=rand.nextInt(celebUrls.size());
        ImageDownloader imagetask=new ImageDownloader();
        Bitmap celebImage;
        try {
            celebImage = imagetask.execute(celebUrls.get(chosenCeleb)).get();
            imageView.setImageBitmap(celebImage);
            int incorrectAnswerLocation;
            locationOfCorrectAnswer = rand.nextInt(4);
            for (int i = 0; i < 4; i++) {
                if (locationOfCorrectAnswer == i)
                    answers[i] = celebNames.get(chosenCeleb);
                else {
                    incorrectAnswerLocation = rand.nextInt(celebUrls.size());
                    while (incorrectAnswerLocation == chosenCeleb) {
                        incorrectAnswerLocation = rand.nextInt(celebUrls.size());

                    }
                    answers[i] = celebNames.get(incorrectAnswerLocation);

                }
            }

            button0.setText(answers[0]);
            button1.setText(answers[1]);
            button2.setText(answers[2]);
            button3.setText(answers[3]);
        }
        catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

    }

    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url=null;
            HttpURLConnection urlConnection=null;
            try {
                url = new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                while(data!=-1){
                    char current=(char) data;
                    result+=current;
                    data=reader.read();
                }
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void startgif(){

    }
    public void endgif(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        startgif();
        String result="";
        imageView=(ImageView) findViewById(R.id.imageView);
        button0=(Button) findViewById(R.id.button0);
        button1=(Button) findViewById(R.id.button1);
        button2=(Button) findViewById(R.id.button2);
        button3=(Button) findViewById(R.id.button3);
        DownloadTask task=new DownloadTask();
        endgif();
        try {

            result=task.execute("http://www.posh24.se/kandisar").get();
            String[] splitResult=result.split("<div class=\"sidebarContainer\">");


            Pattern p=Pattern.compile("img src=\"(.*?)\"");
            Matcher m=p.matcher(splitResult[0]);


            while (m.find()){
                celebUrls.add(m.group(1));
            }


            p=Pattern.compile("alt=\"(.*?)\"");
            m=p.matcher(result);
            while (m.find()){
                celebNames.add(m.group(1));
            }

            generateQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
