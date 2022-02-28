package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private TextView text1,text2;
    private static int Splash_timeout=5000;
    private static final int NOTIFICATION_REMINDER_NIGHT = 1;//this is for the broadcast receiver
    private Intent musicIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //hide bar
        getSupportActionBar().hide();

        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashintent= new Intent(FirstActivity.this,LoginPage.class);
                startActivity(splashintent);
                finish();
            }
        },Splash_timeout);

        Animation myAnimation = AnimationUtils.loadAnimation(FirstActivity.this,R.anim.animation2);
        text1.startAnimation(myAnimation);

        Animation myAnimation2 = AnimationUtils.loadAnimation(FirstActivity.this,R.anim.animation1);
        text2.startAnimation(myAnimation2);


        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 1, pendingIntent);


        //this will start the service which in turn will start the music
        musicIntent= new Intent(this,MusicService.class);
        startService(musicIntent);
    }
}