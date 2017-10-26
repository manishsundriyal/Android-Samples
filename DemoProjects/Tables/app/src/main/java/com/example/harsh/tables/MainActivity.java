package com.example.harsh.tables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView times;

    public void generateTables(int tt) {

        int timesTable = tt;
        ArrayList<String> content = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            content.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, content);
        times.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        times = (ListView) findViewById(R.id.listView);
        final SeekBar timesTables = (SeekBar) findViewById(R.id.timesTables);

        timesTables.setMax(20);
        timesTables.setProgress(10);

        timesTables.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tt;
                if (i < min) {
                    tt = min;
                    timesTables.setProgress(1);
                } else
                    tt = i;
                generateTables(tt);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        generateTables(10);
    }
}
