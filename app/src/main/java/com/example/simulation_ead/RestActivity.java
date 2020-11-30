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
        events.add(new Event(-9, 10, -5, 1,R.drawable.ic_food, "Поесть в сталовой лицея", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-9, 10, -5, 1,R.drawable.ic_breakfast, "Поесть дома", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-9, 10, -5, 1,R.drawable.ic_food_serving, "Поесть в сталовой МИФИ", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-5, 10, -5, 1,R.drawable.ic_hamburger, "Поесть в BurgerKing", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-8, 15, -5, 1,R.drawable.ic_pizza, "Заказать пиццу", MainActivity.createAccessIndicatorForEvent(1)));
        events.add(new Event(-8, 15, -5, 1,R.drawable.ic_food_serving, "Поесть в ресторане", MainActivity.createAccessIndicatorForEvent(1)));
    }
}