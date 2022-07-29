package com.ras.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TemperatureConverter extends AppCompatActivity {
    TextView textView,resultscreen;
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        getSupportActionBar().setTitle("Temperature Converter");

        textView = findViewById(R.id.textview5);
        editText = findViewById(R.id.valueofLitre);
        button = findViewById(R.id.button3);
        resultscreen = findViewById(R.id.resultScreen3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Conversion();
            }
        });
    }

    private void Conversion() {
        //Getting value from the user Side
        String value = editText.getText().toString();
        //Conversion String Value into the double
        double celcius = Double.parseDouble(value);
        //Applying formula for getting the result here now....
        double fahrenheit = (celcius*9/5) + 32;
        //Displaying the result
        resultscreen.setText(" " +fahrenheit);

    }
}