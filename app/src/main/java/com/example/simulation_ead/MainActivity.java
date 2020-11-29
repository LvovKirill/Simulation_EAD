package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Level level = new Level(1, R.drawable.image_lvl_1, 10, "Школьные годы");

    public static TextView textView;
    public static ImageView imageView;
    public static int lvl = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_mind = (Button)findViewById(R.id.btn_mind);
        Button btn_happiness = (Button)findViewById(R.id.btn_happiness);
        Button btn_affairs = (Button)findViewById(R.id.btn_affairs);

        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.image_lvl);

        btn_mind.setOnClickListener(this);
        btn_happiness.setOnClickListener(this);
        btn_affairs.setOnClickListener(this);
    }


    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_mind:
                Intent mind = new Intent(MainActivity.this, MindActivity.class);
                startActivity(mind);
                break;
            case R.id.btn_happiness:
                Intent happiness = new Intent(MainActivity.this, RestActivity.class);
                startActivity(happiness);
                break;
            case R.id.btn_affairs:
                Intent affairs = new Intent(MainActivity.this, AffairsActivity.class);
                startActivity(affairs);
                break;
        }



    }

    static Level mas_lvl[] = {
            new Level(1, R.drawable.image_lvl_1, 10, "Бакалавр МИФИ"),
            new Level(2, R.drawable.image_lvl_2, 8, "Бакалавр МИФИ"),
            new Level(3, R.drawable.image_lvl_2, 6, "Магистр МИФИ"),
            new Level(4, R.drawable.image_lvl_2, 4, "Аспирант МИФИ")
    };

    public static void newLvl(){
        lvl += 1;
        textView.setText(mas_lvl[lvl-1].name_lvl);
        imageView.setImageResource(mas_lvl[lvl-1].image_lvl);

        StatusFragment.progress_mind = 100;
        StatusFragment.progress_rest = 100;
        StatusFragment.progress_affairs = 100;
        StatusFragment.progress_lvl = 0;
    }

    public static void restartGame(){

        textView.setText("Я крут");
        imageView.setImageResource(R.drawable.image_lvl_1);

        StatusFragment.progress_mind = 100;
        StatusFragment.progress_rest = 100;
        StatusFragment.progress_affairs = 100;
        StatusFragment.progress_lvl = 0;

    }
}