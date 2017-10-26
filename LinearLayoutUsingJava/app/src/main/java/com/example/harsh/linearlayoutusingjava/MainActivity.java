package com.example.harsh.linearlayoutusingjava;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    LinearLayout ll;
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        ll=new LinearLayout(this);
//        button=new Button(this);
        textView=new TextView(this);
    button=(Button) findViewById(R.id.button);
        View.OnClickListener o=new Temp();
        button.setOnClickListener(o);
        ViewGroup.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        ll.setLayoutParams(params);

        params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(params);
        textView.setLayoutParams(params);

        ll.setOrientation(LinearLayout.VERTICAL);
        button.setBackgroundColor(Color.BLUE);
        button.setText("Click me");
        textView.setText("Hello World");

        ll.addView(button);
        ll.addView(textView);

        setContentView(R.layout.activity_main);
    }

    public class Temp implements View.OnClickListener{

        @Override
        public void onClick(View view) {

        }
    }
}
