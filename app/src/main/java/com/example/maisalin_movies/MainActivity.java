package com.example.maisalin_movies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private static final int NOTIFICATION_REMINDER_NIGHT = 1;//this is for the broadcast receiver
    private Intent musicIntent;
    private CardView popular1,popular2 ,popular3, movie01,movie02,movie04;
    private RelativeLayout tvShowCard, popularCard, moviesCard, tvShows2Card,  romComsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent notifyIntent = new Intent(this,NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  System.currentTimeMillis(),
                1000 * 60 * 1, pendingIntent);


        //this will start the service which in turn will start the music
        musicIntent= new Intent(this,MusicService.class);
        startService(musicIntent);


        //popularCard =findViewById(R.id.popular1);
        //popularCard.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View view) {
              //  Intent i= new Intent(MainActivity.this,DetailActivity.class);
           //     i.putExtra("name","Divergent");
             //   startActivity(i);
       //     }
      //  });

    }

    public void divergent(View view){
        Intent intent = new Intent(this, Divergent.class);
        startActivity(intent);
    }


    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if(i == dialogInterface.BUTTON_POSITIVE){
            super.onBackPressed();
            dialogInterface.cancel();
        }
        if(i==dialogInterface.BUTTON_NEGATIVE){
            dialogInterface.cancel();
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", this);
        builder.setNegativeButton("No", this);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}