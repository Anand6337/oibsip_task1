package com.ras.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VolumeConverter extends AppCompatActivity {
    TextView textView , result;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_converter);
        getSupportActionBar().setTitle("Volume Converter");
        textView = findViewById(R.id.textview5);
        result = findViewById(R.id.resultScreen3);
        editText = findViewById(R.id.valueofLitre);
        button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conversion();
            }
        });
    }

    private void Conversion() {
        String value = editText.getText().toString();
        //Convert Value from String to Double.....
        float litre = Float.parseFloat(value);
        //Applying the Respective Formula
        float millilitre = (float) litre*1000;
        //Displaying the respective result
        result.setText(" " +millilitre);
    }
}