package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.example.simulation_ead.R.raw.sound_affairs;
import static com.example.simulation_ead.R.raw.sound_brain;
import static com.example.simulation_ead.R.raw.sound_game_over;
import static com.example.simulation_ead.R.raw.sound_rest;
import static com.example.simulation_ead.R.raw.sound_vin;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button btn_restart = (Button)findViewById(R.id.btn_restart);

        btn_restart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MediaPlayer sound;
        MainActivity.restartGame();

        EventAdapter.saveParams();

         sound = MediaPlayer.create( this, sound_game_over);

        sound.start();
        CustomToast.makeText(this, "Вы начали игру заново", Toast.LENGTH_LONG, 1, R.drawable.game_over_photo).show();

        StatusFragment.setProgress_mind();
        StatusFragment.setProgress_rest();
        StatusFragment.setProgress_affairs();
        StatusFragment.setProgress_lvl();
    }
}