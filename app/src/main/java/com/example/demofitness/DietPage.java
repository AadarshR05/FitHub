package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DietPage extends AppCompatActivity {
    private CardView cardView1,cardView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_page);
        cardView1 = (CardView) findViewById(R.id.dietplan);
        cardView2 = (CardView) findViewById(R.id.bmicalc);


        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietPage.this, BMICalculator.class);
                startActivity(intent);
            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietPage.this, DietPlan.class);
                startActivity(intent);
            }
        });

    }
}