package com.example.demofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.ArcProgress;
import com.github.lzyzsd.circleprogress.CircleProgress;
import com.github.lzyzsd.circleprogress.DonutProgress;

public class WaterIntakeActivity extends AppCompatActivity {

    Button ml100, ml50, ml250, ml500, ml750, ml1000, decrease, reminder;
    ArcProgress arcProgress;
    DonutProgress donutProgress;
    CircleProgress circleProgress;
    int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake);
        createNotificationChannel();
        ml50 = findViewById(R.id.up50);
        ml100 = findViewById(R.id.up100);
        ml250 = findViewById(R.id.up250);
        ml500 = findViewById(R.id.up500);
        ml750 = findViewById(R.id.up750);
        ml1000 = findViewById(R.id.up1000);
        decrease = findViewById(R.id.decrease);
        reminder = findViewById(R.id.reminder);

        arcProgress = findViewById(R.id.arc_progress);
        donutProgress = findViewById(R.id.donut_progress);
        circleProgress = findViewById(R.id.circle_progress);

        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(WaterIntakeActivity.this, "Reminder is Set", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(WaterIntakeActivity.this, RemainderBroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(WaterIntakeActivity.this, 0, intent, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick =  System.currentTimeMillis();

                long tenSecondInMillis = 1000 *10;

                alarmManager.set(AlarmManager.RTC_WAKEUP,
                        timeAtButtonClick = tenSecondInMillis,
                        pendingIntent);

            }
        });

        ml50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=2;
                    updateProgressBar();
                }

            }
        });
        ml100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=4;
                    updateProgressBar();
                }

            }
        });
        ml250.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=10;
                    updateProgressBar();
                }

            }
        });
        ml500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=20;
                    updateProgressBar();
                }

            }
        });
        ml750.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=30;
                    updateProgressBar();
                }

            }
        });
        ml1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress<=100){
                    progress +=40;
                    updateProgressBar();
                }

            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progress>=10){
                    progress -=10;
                    updateProgressBar();
                }

            }
        });


    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){

            CharSequence name = "WaterIntakeReminderChannel";
            String description = "Water Intake Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("waterIntake", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void updateProgressBar() {
        donutProgress.setDonut_progress(String.valueOf(progress));
        arcProgress.setProgress(progress);
        circleProgress.setProgress(progress);
    }
}