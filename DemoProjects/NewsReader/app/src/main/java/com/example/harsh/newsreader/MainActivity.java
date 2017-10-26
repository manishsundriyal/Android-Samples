package com.example.harsh.newsreader;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> titles=new ArrayList<>();
    ArrayAdapter<String> adapter;
    ArrayList<String> contents=new ArrayList<>();
    SQLiteDatabase articleDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView) findViewById(R.id.listView);
        String result;
        adapter = new ArrayAdapter<String> (this,android.R.layout.simple_list_item_1,titles);
        listView.setAdapter(adapter);

        articleDB=this.openOrCreateDatabase("articles",MODE_PRIVATE,null);

        articleDB.execSQL("CREATE TABLE IF NOT EXISTS articles (id INTEGER PRIMARY KEY, articleId INTEGER, title VARCHAR, content VARCHAR)");

        updateListView();
        DownloadTask downloadTask=new DownloadTask();
        try {
            result=(String) downloadTask.execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty").get();



        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }



    public void updateListView(){

        Cursor c=articleDB.rawQuery("SELECT * FROM articles",null);

        int contentIndex=c.getColumnIndex("content");
        int titleIndex=c.getColumnIndex("title");

        if(c.moveToFirst()){

            titles.clear();
            contents.clear();
            do{
                titles.add(c.getString(titleIndex));
                contents.add(c.getString(contentIndex));

            }while(c.moveToNext());

            adapter.notifyDataSetChanged();



        }
    }


    public class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;

            try {
                url=new URL(urls[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream in=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(in);

                int data=reader.read();

                while(data!=-1){
                    char ch=(char) data;
                    result+=ch;
                    data=reader.read();
                }

                //Log.i("REsult",result);

                int numberOfItems=20;

                articleDB.execSQL("DELETE from articles");
                JSONArray jsonArray=new JSONArray(result);
                if(jsonArray.length() < numberOfItems)
                    numberOfItems=jsonArray.length();
                for(int i=0;i<numberOfItems;i++){

                    String articleId=jsonArray.getString(i);
                   url=new URL("https://hacker-news.firebaseio.com/v0/item/"+ articleId + ".json?print=pretty");
                    urlConnection =(HttpURLConnection) url.openConnection();
                    urlConnection.connect();
                    in=urlConnection.getInputStream();
                    reader=new InputStreamReader(in);
                    String articleInfo="";

                    data=reader.read();
                    while(data!=-1){
                        char ch=(char) data;
                        articleInfo+=ch;
                        data=reader.read();
                    }

                    //Log.i("article INfo",articleInfo);

                    JSONObject jsonObject=new JSONObject(articleInfo);

                    if(!jsonObject.isNull("title") && !jsonObject.isNull("url")){

                        String articleTitle=jsonObject.getString("title");
                        String articleUrl=jsonObject.getString("url");

//                        Log.i("INFOS",articleTitle + "    "+articleUrl);

                        url=new URL(articleUrl);
                        urlConnection =(HttpURLConnection) url.openConnection();
                        urlConnection.connect();
                        in=urlConnection.getInputStream();
                        reader=new InputStreamReader(in);
                        String articleContent="";

                        data=reader.read();
                        while(data!=-1){
                            char ch=(char) data;
                            articleContent+=ch;
                            data=reader.read();
                        }

                       // Log.i("Article Content",articleContent);
                        String sql="INSERT INTO articles (articleId, title, content) VALUES (?, ?, ?)";
                        SQLiteStatement statement=articleDB.compileStatement(sql);
                        statement.bindString(1,articleId);
                        statement.bindString(2,articleTitle);
                        statement.bindString(3,articleContent);


                        statement.execute();
                    }


                }



            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            updateListView();
        }
    }
}
