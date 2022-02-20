package com.example.maisalin_movies;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service {
    MediaPlayer mediaplayer;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }
    //this method is called when the service is started
    @Override
    public void onCreate() {
        super.onCreate();
        mediaplayer= MediaPlayer.create(this,R.raw.music0);
        mediaplayer.setLooping(true);
        mediaplayer.setVolume(100,100);

    }

    //when the service is started
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaplayer.start(); //starts the music
        return super.onStartCommand(intent, flags, startId);
    }
    //when the service is destroyed stop playing the music
    @Override
    public void onDestroy() {
        mediaplayer.stop();
    }


}