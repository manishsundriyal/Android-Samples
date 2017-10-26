package com.example.harsh.importimagesdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&& requestCode==RESULT_OK && data!=null){

            Uri selectedImage=data.getData();
            try {
                Bitmap image=MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                ImageView imageView=(ImageView) findViewById(R.id.imageView);
                imageView.setImageBitmap(image);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
