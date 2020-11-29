package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AffairsActivity extends AppCompatActivity {

    ArrayList<Event> events = new ArrayList<Event>();
    EventAdapter eventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affairs);

        fillData();
        eventAdapter = new EventAdapter(this, events);

        ListView lvMain = (ListView) findViewById(R.id.listView_affairs);
        lvMain.setAdapter(eventAdapter);

    }

    void fillData() {
        events.add(new Event(-5, -5, 10, 1, "Учить физку"));
        events.add(new Event(-5, -5, 10, 1, "Учить физку"));
        events.add(new Event(-5, -5, 10, 1, "Учить физку"));

    }
}