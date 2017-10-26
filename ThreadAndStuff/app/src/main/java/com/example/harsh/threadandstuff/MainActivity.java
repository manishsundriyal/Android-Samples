package com.example.harsh.threadandstuff;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText editText;
    ListView listView;
    String[] listOfImages;
    ProgressBar progressBar;
    LinearLayout loadingSection=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.downloadURL);
        listView= (ListView) findViewById(R.id.urlList);
        listView.setOnItemClickListener(this);
        listOfImages = getResources().getStringArray(R.array.imageUrls);
        progressBar= (ProgressBar) findViewById(R.id.downloadProgress);

        loadingSection= (LinearLayout) findViewById(R.id.loadingSection);

    }

    public void downloadImage(View view){

        String url=editText.getText().toString();

        //it takes a runnable as a parameter
        //and we provided one which we had implemented
        Thread myThread=new Thread(new DownloadImagesThread(url));
        //this ensures that our code runs on a different thread
        myThread.start();
        //don't forget internet permission


        //we want to save the image with the
        //last segment name of the url
        //uri class has a function called getLastPathSegment
        //every forward slash seperates a segment
//        Uri uri=Uri.parse(url);
//        L.s(this,file.getAbsolutePath());



    }

    public boolean downloadImageUsingThreads(String url){
        boolean successful=false;
        URL downloadUrl=null;
        HttpURLConnection connection = null;
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        File file=null;

        //reading a single byte was very slow, so we will read an array
        //of bytes at once


//        try {
//            downloadUrl=new URL(url);
//            connection= (HttpURLConnection) downloadUrl.openConnection();
//
//            inputStream=connection.getInputStream();
//
//            int read=-1;
//            while ((read=inputStream.read())!=-1){
//
//                L.m(read+"");
//            }
//
//
//        }
        try {

           downloadUrl=new URL(url);
           connection= (HttpURLConnection) downloadUrl.openConnection();

           inputStream=connection.getInputStream();

//           File file=new File();
           int read=-1;

            //this gave permission denied
            //so wrote it in the location below
//            file=new File(Environment.getExternalStoragePublicDirectory
//                    (Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
//                    +"/" + Uri.parse(url).getLastPathSegment());
//

           file=new File(getExternalFilesDir("myApp").getAbsolutePath()
                   + "/" + Uri.parse(url).getLastPathSegment());

           byte[] buffer=new byte[1024];

            fileOutputStream=new FileOutputStream(file);
           while ((read=inputStream.read(buffer))!=-1){

               //read har baar different number of bytes
               //ko read karta hai, and it is given by read variable
               //toh humne bola, read from 0 to the number
               //of bytes in that buffer
                fileOutputStream.write(buffer,0,read);
            }
            successful=true;

       }
           catch(Exception e) {
            e.printStackTrace();
        }
        finally {

            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingSection.setVisibility(View.GONE );
                }
            });

            if(connection!=null){
                connection.disconnect();
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return successful;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText(listOfImages[i]);

    }

    private class DownloadImagesThread implements Runnable{

        private String url;

        DownloadImagesThread(String url){
            this.url=url;

        }
        //this runs on background thread
        @Override
        public void run() {
            //I cannot update Ui from here, so needed this method
            //but i want this to run on the main thread
            //so used the runOnUiThread method
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    loadingSection.setVisibility(View.VISIBLE);
                }
            });
            downloadImageUsingThreads(url);
        }
    }

}
