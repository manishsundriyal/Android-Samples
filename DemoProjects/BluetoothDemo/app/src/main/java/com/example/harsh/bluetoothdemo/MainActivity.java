package com.example.harsh.bluetoothdemo;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter BA;

    public void turnBluetoothOff(View view){

        BA.disable();

        if(BA.isEnabled()){

            Toast.makeText(this, "Bluetooth could not be disabled", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Bluetooth is turned OFF", Toast.LENGTH_SHORT).show();
        }
    }

    public void findDiscoverableDevices(View view){
        Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        startActivity(i);

    }

    public void viewPairedDevices(View view){
        Set<BluetoothDevice> pairedDevices=BA.getBondedDevices();
        ListView pairedDevicesListView=(ListView) findViewById(R.id.pairedDevicesListView);

        ArrayList arrayList=new ArrayList();

        for(BluetoothDevice bluetoothDevice: pairedDevices){
            arrayList.add(bluetoothDevice.getName());
        }

        ArrayAdapter arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arrayList);
        pairedDevicesListView.setAdapter(arrayAdapter);
        


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(BA.isEnabled()){
            Toast.makeText(this, "Bluetooth is On", Toast.LENGTH_SHORT).show();
        }else{

            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivity(i);
            if(BA.isEnabled()){

                Toast.makeText(this, "Bluetooth is turned On", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
