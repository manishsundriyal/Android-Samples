package com.example.harsh.framelayout;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.textView);
        button=(Button) findViewById(R.id.button);

        Typeface customFont=Typeface.createFromAsset(getAssets(),"fonts/Nosifer-Regular.ttf");
        textView.setTypeface(customFont);

    }

    public void buttonClicked(View view){
        Intent intent=new Intent(this, MyActivity.class);

        startActivity(intent);
    }
}
