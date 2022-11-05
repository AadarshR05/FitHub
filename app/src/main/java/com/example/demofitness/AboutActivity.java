package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        imageSlider = findViewById(R.id.image_slider);

        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel("https://thumbs.dreamstime.com/z/woman-stretching-muscles-gym-workout-weight-training-home-living-room-female-fitness-athlete-doing-warm-up-woman-144081448.jpg",null));
        images.add(new SlideModel("https://thumbs.dreamstime.com/z/balanced-diet-food-background-balanced-diet-food-background-organic-food-healthy-nutrition-superfoods-meat-fish-legumes-nuts-121936796.jpg",null));
        images.add(new SlideModel("https://thumbs.dreamstime.com/z/personal-trainer-training-client-weights-lifting-62370879.jpg",null));
        images.add(new SlideModel("https://thumbs.dreamstime.com/z/woman-checking-progress-app-health-tracking-activity-smartphone-fitness-concept-all-screen-graphics-made-up-us-141518137.jpg",null));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
    }
}