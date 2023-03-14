package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void OnTapeClick(View view){
        TextView UnitTypeText = findViewById(R.id.UnitTypeTextView);
        UnitTypeText.setText("Distance Converter:");

        // set unit type to 1 (Distance)
        unitType = 1;

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

        // set unit type to 2 (Temperature)
        unitType = 2;

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

        // set unit type to 3 (Weight)
        unitType = 3;

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
    private int unitType = 0;
    private int source = -1;
    private int dest = -1;

    public void onConvertClick(View view){
        // set some variables
        EditText inputField = findViewById(R.id.editTextNumber);
        TextView resultText = findViewById(R.id.resultTextView);
        float result = 0;
        float input = 0;
    // check a valid number
    try {
        input = Float.valueOf(inputField.getText().toString());
    } catch (NumberFormatException e) {
        Toast invalNumber = Toast.makeText(getApplicationContext(), "Please select a valid number to convert.", Toast.LENGTH_SHORT);
        invalNumber.show();
    }
        // alert to no number to convert
        if(input == 0){
            Toast enterNumToast = Toast.makeText(getApplicationContext(), "Please enter a value for calculation,", Toast.LENGTH_SHORT);
            enterNumToast.show();
            return;
        }
        // process no type selected
        if(unitType == 0){
            Toast selectTypeToast = Toast.makeText(getApplicationContext(), "Please select a unit type for conversion.", Toast.LENGTH_SHORT);
            selectTypeToast.show();
        }
        // process distance
        else if (unitType == 1) {
            result = distanceCalculator(input, source, dest);
        }
        // process temp
        else if (unitType == 2) {
            result = tempCalculator(input, source, dest);
        }
        // process weight
        else if (unitType == 3) {
            result = weightCalculator(input, source, dest);
        }


        resultText.setText(Float.toString(result));
    }

    private float distanceCalculator(float input, int source, int dest){
        switch (source){
            case 0:
                switch(dest){
                    case 0:
                        return input;
                    case 1:
                        return (float) (input * 39370.1);
                    case 2:
                        return (float) (input * 3280.84);
                    case 3:
                        return (float) (input * 1093.61);
                    case 4:
                        return (float) (input * 0.621371);
                    }
            case 1:
                switch(dest){
                    case 0:
                        return (float) (input * 2.54e-5);
                    case 1:
                        return (float) (input);
                    case 2:
                        return (float) (input * 0.0833333);
                    case 3:
                        return (float) (input * 0.0277778);
                    case 4:
                        return (float) (input * 1.5783e-5);
                }
            case 2:
                switch(dest){
                    case 0:
                        return (float) (input * 0.0003048);
                    case 1:
                        return (float) (input * 12);
                    case 2:
                        return (float) (input);
                    case 3:
                        return (float) (input * 0.333333);
                    case 4:
                        return (float) (input * 0.000189394);
                }
            case 3:
                switch(dest){
                    case 0:
                        return (float) (input * 0.0009144);
                    case 1:
                        return (float) (input * 36);
                    case 2:
                        return (float) (input * 3);
                    case 3:
                        return (float) (input);
                    case 4:
                        return (float) (input * 0.000568182);
                }
            case 4:
                switch(dest){
                    case 0:
                        return (float) (input * 1.60934);
                    case 1:
                        return (float) (input * 63360);
                    case 2:
                        return (float) (input * 5280);
                    case 3:
                        return (float) (input * 1760);
                    case 4:
                        return (float) (input);
                }

            default:
                Toast invalSelectionToast = Toast.makeText(getApplicationContext(), "Please select source and destination unit", Toast.LENGTH_SHORT);
                invalSelectionToast.show();
        }
        return 0;
    }

    private float tempCalculator(float input, int source, int dest){
        switch (source){
            case 0:
                switch(dest){
                    case 0:
                        return (float) input;
                    case 1:
                        return (float) ((input * 1.8) + 32);
                    case 2:
                        return (float) (input + 273.15);

                }
            case 1:
                switch(dest){
                    case 0:
                        return (float) ((input - 32) * 0.55555556);
                    case 1:
                        return (float) (input);
                    case 2:
                        return (float) ((input - 32) * 0.55555556 + 273.15);

                }
            case 2:
                switch(dest){
                    case 0:
                        return (float) (input - 273.15);
                    case 1:
                        return (float) ((input - 273.15) * 1.8 + 32);
                    case 2:
                        return (float) (input);
                }


            default:
                Toast invalSelectionToast = Toast.makeText(getApplicationContext(), "Please select source and destination unit", Toast.LENGTH_SHORT);
                invalSelectionToast.show();
        }
        return 0;
    }

    private float weightCalculator(float input, int source, int dest){
        switch (source){
            case 0:
                switch(dest){
                    case 0:
                        return input;
                    case 1:
                        return (float) (input * 2.20462);
                    case 2:
                        return (float) (input * 35.274);
                    case 3:
                        return (float) (input * 0.001);

                }
            case 1:
                switch(dest){
                    case 0:
                        return (float) (input * 0.453592);
                    case 1:
                        return (float) (input);
                    case 2:
                        return (float) (input * 16);
                    case 3:
                        return (float) (input * 0.000453592);

                }
            case 2:
                switch(dest){
                    case 0:
                        return (float) (input * 0.0283495);
                    case 1:
                        return (float) (input * 0.0625);
                    case 2:
                        return (float) (input);
                    case 3:
                        return (float) (input * 2.835e-5);

                }
            case 3:
                switch(dest){
                    case 0:
                        return (float) (input * 1000);
                    case 1:
                        return (float) (input * 2204.62);
                    case 2:
                        return (float) (input * 35274);
                    case 3:
                        return (float) (input);

                }


            default:
                Toast invalSelectionToast = Toast.makeText(getApplicationContext(), "Please select source and destination unit", Toast.LENGTH_SHORT);
                invalSelectionToast.show();
        }
        return 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.sourceSpinner){
            source = position;
        } else if (parent.getId()== R.id.destinaionSpinner) {
            dest = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}