package com.example.harsh.threadandstuff;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
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
import java.net.URL;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText editText;
    ListView listView;
    String[] listOfImages;
    ProgressBar progressBar;
    LinearLayout loadingSection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.downloadURL);
        listView = (ListView) findViewById(R.id.urlList);
        listView.setOnItemClickListener(this);
        listOfImages = getResources().getStringArray(R.array.imageUrls);
        progressBar = (ProgressBar) findViewById(R.id.downloadProgress);

        loadingSection = (LinearLayout) findViewById(R.id.loadingSection);



    }

    public void downloadImage(View view) {

        String url = editText.getText().toString();

        if (url != null && url.length() > 0) {
            MyTask myTask = new MyTask(this);
            myTask.execute(url);

        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText(listOfImages[i]);

    }


    //We needed to access Progress Bar from here
    //But we cant do it, if it is a external class
    //That the reasons most AsyncTask classes
    //are innner classes.
    class MyTask extends AsyncTask<String, Integer, Boolean> {


        //these two are needed for Progress Bar
        //to record total size of the file
        private int contentLength=-1;
        //to record no. of bytes read
        private int counter=0;

        //onProgressUpdate is gonna get called many times
        //so not a good idea to declare a variable ther
        private int calculatedProgress=0;


        //needed to access getExternalFilesDir
        Context context;

        public MyTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            loadingSection.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(String... params) {
            boolean successful = false;
            URL downloadUrl = null;
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            File file = null;

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

                String url = params[0];
                downloadUrl = new URL(url);
                connection = (HttpURLConnection) downloadUrl.openConnection();

                //this returns us the length of the content
                //we need to store it to update the progressbar
                contentLength=connection.getContentLength();
                inputStream = connection.getInputStream();

//           File file=new File();
                int read = -1;

                //this gave permission denied
                //so wrote it in the location below
//            file=new File(Environment.getExternalStoragePublicDirectory
//                    (Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()
//                    +"/" + Uri.parse(url).getLastPathSegment());
//

                file = new File(context.getExternalFilesDir("myApp").getAbsolutePath()
                        + "/" + Uri.parse(url).getLastPathSegment());

                byte[] buffer = new byte[1024];

                fileOutputStream = new FileOutputStream(file);
                while ((read = inputStream.read(buffer)) != -1) {

                    //read har baar different number of bytes
                    //ko read karta hai, and it is given by read variable
                    //toh humne bola, read from 0 to the number
                    //of bytes in that buffer



                    fileOutputStream.write(buffer, 0, read);
                    //it reads read no. of bytes
                    counter=counter+read;
                    publishProgress(counter);
                }
                successful = true;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
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
        protected void onProgressUpdate(Integer... values) {
            calculatedProgress=(values[0]*100)/contentLength;
            progressBar.setProgress(calculatedProgress);

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}