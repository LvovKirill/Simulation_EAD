package com.example.simulation_ead;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Event{
    int mind;
    int requirements;
    int happiness;
    int lvl_access;
    String event_class;
    String event;


    Event (int mind, int requirements, int happiness, int lvl_access, String event_class, String event){
        this.mind=mind;
        this.requirements=requirements;
        this.happiness=happiness;
        this.lvl_access=lvl_access;
        this.event_class=event_class;
        this.event=event;
    }

    Event(String event){
        this.event=event;
    }

}
