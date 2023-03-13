package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void OnTapeClick(View view){
        TextView UnitTypeText = findViewById(R.id.UnitTypeTextView);
        UnitTypeText.setText("Distance Converter:");
         // Setup Source Spinner
        Spinner sourceSpinner = findViewById(R.id.sourceSpinner);
        ArrayAdapter<CharSequence> sourceAdapter = ArrayAdapter.createFromResource(this,R.array.Distance, android.R.layout.simple_spinner_item);
        sourceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(sourceAdapter);
        sourceSpinner.setOnItemSelectedListener(this);

        // Setup Destination Spinner
        Spinner destinationSpinner = findViewById(R.id.destinaionSpinner);
        ArrayAdapter<CharSequence> destinationAdapter = ArrayAdapter.createFromResource(this,R.array.Distance, android.R.layout.simple_spinner_item);
        destinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(destinationAdapter);
        destinationSpinner.setOnItemSelectedListener(this);
    }

    public void OnTempClick(View view){
        TextView UnitTypeText = findViewById(R.id.UnitTypeTextView);
        UnitTypeText.setText("Temperature Converter:");

        // Setup Source Spinner
        Spinner sourceSpinner = findViewById(R.id.sourceSpinner);
        ArrayAdapter<CharSequence> sourceAdapter = ArrayAdapter.createFromResource(this,R.array.Temperature, android.R.layout.simple_spinner_item);
        sourceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(sourceAdapter);
        sourceSpinner.setOnItemSelectedListener(this);

        // Setup Destination Spinner
        Spinner destinationSpinner = findViewById(R.id.destinaionSpinner);
        ArrayAdapter<CharSequence> destinationAdapter = ArrayAdapter.createFromResource(this,R.array.Temperature, android.R.layout.simple_spinner_item);
        destinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(destinationAdapter);
        destinationSpinner.setOnItemSelectedListener(this);
    }

    public void OnWeightClick(View view){
        TextView UnitTypeText = findViewById(R.id.UnitTypeTextView);
        UnitTypeText.setText("Weight Converter:");

        // Setup Source Spinner
        Spinner sourceSpinner = findViewById(R.id.sourceSpinner);
        ArrayAdapter<CharSequence> sourceAdapter = ArrayAdapter.createFromResource(this,R.array.Weight, android.R.layout.simple_spinner_item);
        sourceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceSpinner.setAdapter(sourceAdapter);
        sourceSpinner.setOnItemSelectedListener(this);

        // Setup Destination Spinner
        Spinner destinationSpinner = findViewById(R.id.destinaionSpinner);
        ArrayAdapter<CharSequence> destinationAdapter = ArrayAdapter.createFromResource(this,R.array.Weight, android.R.layout.simple_spinner_item);
        destinationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(destinationAdapter);
        destinationSpinner.setOnItemSelectedListener(this);

    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}