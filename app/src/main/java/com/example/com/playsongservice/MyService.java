package com.example.com.playsongservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String ACTION_PLAY = "com.example.action.PLAY";
    MediaPlayer mediaPlayer = null;


    public MyService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.

        String play = intent.getStringExtra("key");
        if (play != null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.mysong);
            if (play.equals("play")) {
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                Toast.makeText(this, "Play song", Toast.LENGTH_LONG).show();
            } else {
                mediaPlayer.pause();
                mediaPlayer.reset();
                mediaPlayer.release();
                Toast.makeText(this, "Stop song", Toast.LENGTH_LONG).show();
            }
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
