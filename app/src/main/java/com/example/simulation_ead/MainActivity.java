package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_mind = (Button)findViewById(R.id.btn_mind);
        Button btn_happiness = (Button)findViewById(R.id.btn_happiness);
        Button btn_affairs = (Button)findViewById(R.id.btn_affairs);

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
}