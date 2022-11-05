package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        EditText textkg,textcm;
        TextView textdetail,textbmi;
        Button bmiresult,bmireset;


        textkg = (EditText) findViewById(R.id.text_kg);
        textcm = (EditText) findViewById(R.id.text_cm);


        textdetail = (TextView) findViewById(R.id.text_detail);
        textbmi = (TextView) findViewById(R.id.text_bmi);

        bmiresult = (Button) findViewById(R.id.bmi_result);
        bmireset = (Button) findViewById(R.id.bmi_reset);


        bmiresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strweg=textkg.getText().toString();
                String strhei=textcm.getText().toString();
                if(strweg.equals("")){
                    textkg.setError("Please enter your weight");
                    textkg.requestFocus();
                    return;
                }
                if(strhei.equals("")){
                    textcm.setError("Please enter your height");
                    textcm.requestFocus();
                    return;
                }
                float weight = Float.parseFloat(strweg);
                float height = Float.parseFloat(strhei)/100;

                float bmiValue = BMIcalculate(weight,height);

                textbmi.setText(interpreteBMI(bmiValue));
                textdetail.setText("BMI="+bmiValue);
            }
        });
        bmireset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textcm.setText("");
                textkg.setText("");
                textdetail.setText("");
                textbmi.setText("");
            }
        });


    }
    public float BMIcalculate(float weight,float height){
        return weight / (height*height);
    }
    public String interpreteBMI(float bmiValue){
        if(bmiValue<16){
            return "Severely Underweight";
        }
        if(bmiValue<18.5){
            return "Underweight";
        }
        else if(bmiValue<25){
            return "Normal";
        }
        else if(bmiValue<30){
            return "Overweight";
        }
        else
            return "Obese";
    }
}