package com.example.harsh.vivztest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast=new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM,0,0);

        LayoutInflater layoutInflater=getLayoutInflater();
        View appear=layoutInflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.ll));
        toast.setView(appear);
        toast.show();

    }

    public void process(View view){
        Intent intent=null,choser=null;
        if(view.getId()==R.id.launchMap){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.067,78.8777"));//give no spacing in string, otherwise app crashes
//            choser=Intent.createChooser(intent,"Launch Maps");
//            startActivity(choser);
            startActivity(intent);
        }

        if(view.getId()==R.id.launchMarket){
            intent=new Intent((Intent.ACTION_VIEW));
            intent.setData(Uri.parse("market://details?id=com.BeresnevGames.Knife"));
            startActivity(intent);
        }

        if(view.getId()==R.id.sendEmail){

            String[] to={"harshbhardwaj2357@gmail.com"};
            intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"Hi. Sent from app");
            intent.putExtra(Intent.EXTRA_TEXT,"hey whats up. Just testing some features.");
            intent.setType("message/rfc822");
            choser=Intent.createChooser(intent,"Send with ??");
            startActivity(choser);
        }


        if(view.getId()==R.id.sendImage){
            Uri imageUri=Uri.parse("android.resource://com.example.harsh.vivztest/drawable/"+R.drawable.ic_stat_name);
            intent=new Intent(Intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageUri);
            intent.putExtra(Intent.EXTRA_TEXT,"attached the image with this");
            choser=Intent.createChooser(intent,"Choose app");
            startActivity(choser);
        }

        if(view.getId()==R.id.sendMultipleImages){
            File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            Uri uri=null;
            ArrayList<Uri> arrayList=new ArrayList<Uri>();
            String[] listOfPictures=pictures.list();
            for(String picture:listOfPictures){
                uri=Uri.parse("file://"+pictures.toString()+"/"+picture);
                arrayList.add(uri);
            }
            intent=new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,arrayList);
            choser=Intent.createChooser(intent,"Send using :");
            startActivity(choser);
        }

        File imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
        if(view.getId()==R.id.takePicture){


            Uri tempUri=Uri.fromFile(imageFile);
            intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,tempUri);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
            startActivityForResult(intent,0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            switch (resultCode){
                case Activity.RESULT_OK :
                    //do something

                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:break;
            }
        }

    }
}
