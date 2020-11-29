package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class RestActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<Event>();
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        fillData();
        eventAdapter = new EventAdapter(this, events);

        ListView lvMain = (ListView) findViewById(R.id.listView_rest);
        lvMain.setAdapter(eventAdapter);

    }

    void fillData() {
        events.add(new Event(-9, 10, -5, 1, "Попать в сталовой лицея"));
        events.add(new Event(-9, 10, -5, 1, "Поесть дома"));
        events.add(new Event(-9, 10, -5, 1, "Поесть в сталовой МИФИ"));
        events.add(new Event(-8, 15, -5, 1, "Поесть в ресторане"));
        events.add(new Event(-5, 10, -5, 1, "Поесть в BurgerKing"));
    }
}