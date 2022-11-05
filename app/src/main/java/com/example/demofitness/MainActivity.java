package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolBar);
        //setSupportActionBar(toolbar);

        button1 = findViewById(R.id.startBasic);
        button2 = findViewById(R.id.startIntermediate);
        button3 = findViewById(R.id.startAdvanced);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicActivity.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdvancedActivity.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntermediateActivity.class);
                startActivity(intent);

            }
        });
    }

   // private void setSupportActionBar(Toolbar toolbar) {
   // }

    public void intermediate(View view) {
        Intent intent = new Intent(MainActivity.this, IntermediateActivity.class);
        startActivity(intent);
    }

    public void advanced(View view) {
        Intent intent = new Intent(MainActivity.this, AdvancedActivity.class);
        startActivity(intent);
    }

    public void basic(View view) {
        Intent intent = new Intent(MainActivity.this, BasicActivity.class);
        startActivity(intent);
    }

}