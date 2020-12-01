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
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_peresdacha,3, "Сдать ПКР", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_five,3,"Закрыть семестр", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_paper,3, "Переписать СР", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_coding,3, "Написать интересный алгоритм", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_zachotka,3, "Закрыть сессию", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, -5, 10, 1, R.drawable.ic_neuro_net,3, "Написать нейросеть", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(20, -5, -5, 3, R.drawable.ic_twitch, 3, "Провести стрим", MainActivity.createAccessIndicatorForEvent(3)));
        events.add(new Event(20, -5, -5, 3, R.drawable.ic_youtube, 3, "Записать роли для ютуб", MainActivity.createAccessIndicatorForEvent(3)));

    }
}