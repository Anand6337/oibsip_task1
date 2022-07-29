package com.ras.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    String units[] = {"Weight (Kilogram to Gram) ","Temperature(Celsius to Fahrenheit)","Currency (Rupee to Dollar)","Volume (Litre to MilliLitre)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_item);
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,units);
        listView.setAdapter(arrayAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if (i == 0) {
                   Intent intent = new Intent(MainActivity.this, WeightConverter.class);
                   startActivity(intent);
               }else if(i == 1)
               {
                   Intent intent1 = new Intent(MainActivity.this, TemperatureConverter.class);
                   startActivity(intent1);
               }
               else if(i == 2)
               {
                    Intent intent = new Intent(MainActivity.this,CurrencyConverter.class);
                    startActivity(intent);
               }
               else
               {
                   Intent intent = new Intent(MainActivity.this,VolumeConverter.class);
                   startActivity(intent);
               }

           }
       });






    }
}