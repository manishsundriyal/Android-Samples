package com.example.harsh.jsonexample;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {


    public class GetData extends AsyncTask<String ,Void,String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                String result="";
                URL url=new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();

                connection.connect();
                InputStream in=connection.getInputStream();
                InputStreamReader reader= new InputStreamReader(in);
                int data;
                data=reader.read();
                while (data!=-1){
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

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            GetData task=new GetData();
            try {

                JSONObject jsonObject=new JSONObject(result);
                String weatherInfo=jsonObject.getString("weather");
                JSONArray arr=new JSONArray(weatherInfo);

                for(int i=0;i<arr.length();i++) {
                    JSONObject jsonPart= arr.getJSONObject(i);
                    Log.i("testing",jsonPart.getString("main"));
                    Log.i("testing",jsonPart.getString("description"));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
