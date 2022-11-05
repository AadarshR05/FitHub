package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DietPlan extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<Diet> dietArrayList;
    MyAdapter myAdapter;
    String[] dietHeading;
    String[] briefDiet;
    int[] imageResources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan);

        recyclerView = findViewById(R.id.recyclerrView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        dietArrayList = new ArrayList<Diet>();

        myAdapter = new MyAdapter(this,dietArrayList);
        recyclerView.setAdapter(myAdapter);

        dietHeading = new String[]{

                "DAY 1","DAY 2","DAY 3","DAY 4","DAY 5","DAY 6","DAY 7"
        };
        briefDiet = new String[]{
                getString(R.string.day_1),
                getString(R.string.day_2),
                getString(R.string.day_3),
                getString(R.string.day_4),
                getString(R.string.day_5),
                getString(R.string.day_6),
                getString(R.string.day_7),
        };
        imageResources = new int[]{
                R.drawable.monday,
                R.drawable.tuesday,
                R.drawable.wednesday,
                R.drawable.thursday,
                R.drawable.friday,
                R.drawable.saturday,
                R.drawable.sunday,
        };

        getData();

    }
    private void getData(){
        for(int i=0;i<dietHeading.length;i++){

            Diet diet = new Diet(dietHeading[i],briefDiet[i],imageResources[i]);
            dietArrayList.add(diet);

        }
        myAdapter.notifyDataSetChanged();
    }
}