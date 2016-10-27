package com.example.com.playsongservice;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void stopSong(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key", "stop");
        stopService(intent);
    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("key", "play");
        startService(intent);
    }

    /*
    *     public void stopSong(View view) {
        stopService(new Intent("com.example.com.playsongservice.START_AUDIO_SERVICE"));
        finish();
    }

    public void startService(View view) {
        startService(new Intent("com.example.com.playsongservice.START_AUDIO_SERVICE"));
    }
    * */

}
