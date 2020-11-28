package com.example.simulation_ead;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class Event extends AppCompatActivity {
    int mind;
    int requirements;
    int happiness;
    int lvl_access;
    String event_class;
    String event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

    }

    Event (int mind, int requirements, int happiness, int lvl_access, String event_class, String event){
        this.mind=mind;
        this.requirements=requirements;
        this.happiness=happiness;
        this.lvl_access=lvl_access;
        this.event_class=event_class;
        this.event=event;
    }


    private void creatEventBlock(){
        ImageView imageView = (ImageView)findViewById(R.id.imageEvant);
        TextView textView = (TextView)findViewById(R.id.textEvant);

        textView.setText(event);

    }
}
