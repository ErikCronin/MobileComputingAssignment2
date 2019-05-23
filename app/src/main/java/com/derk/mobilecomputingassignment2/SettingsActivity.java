package com.derk.mobilecomputingassignment2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    @SuppressLint("SetTextI18n")
    public void buttonClicked_soundSwitch(View view){
        Button button = findViewById(R.id.button_sound);
        if(MainActivity.sound_check == 1){
            MainActivity.sound_check = 0;
            button.setText("Off");
        } else {
            MainActivity.sound_check = 1;
            button.setText("On");
        }
    }
}
