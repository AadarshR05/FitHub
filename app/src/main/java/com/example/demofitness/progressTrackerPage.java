package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class progressTrackerPage extends AppCompatActivity {

    private CardView cardView1, cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_tracker_page);
        cardView1 = (CardView) findViewById(R.id.stepcounter);
        cardView2 = (CardView) findViewById(R.id.waterintake);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(progressTrackerPage.this, PedoMeter.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(progressTrackerPage.this, WaterIntakeActivity.class);
                startActivity(intent);
            }
        });

    }
}