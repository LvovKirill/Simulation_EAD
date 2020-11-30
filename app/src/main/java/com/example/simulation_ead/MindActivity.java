package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MindActivity extends AppCompatActivity {

     ArrayList<Event> events = new ArrayList<Event>();

 EventAdapter eventAdapter;ListView lvMain;


public  void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_mind);

//    Fragment fragment_status = new StatusFragment();
//    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.add(R.id.mind_status_container, fragment_status);
//    transaction.commit();


fillData();
eventAdapter = new EventAdapter(this, events);

lvMain = (ListView) findViewById(R.id.listView_mind);
lvMain.setAdapter(eventAdapter);
}

         void fillData() {
events.add(new Event(10, -5, -5, 1, R.drawable.ic_atom, "Учить физку", MainActivity.createAccessIndicatorForEvent(1)));
events.add(new Event(10, -5, -5, 1,R.drawable.ic_calculator, "Учить математику", MainActivity.createAccessIndicatorForEvent(1)));
events.add(new Event(10, -5, -5, 2,R.drawable.ic_computer, "Учить С++", MainActivity.createAccessIndicatorForEvent(2)));
events.add(new Event(10, -5, -5, 2,R.drawable.ic_test, "Готовиться к ПКР", MainActivity.createAccessIndicatorForEvent(2)));
events.add(new Event(10, -5, -5, 2,R.drawable.ic_test, "Готовиться к ЕГЭ", MainActivity.createAccessIndicatorForEvent(2)));
events.add(new Event(20, -5, -5, 3,R.drawable.ic_integral, "Учить высшую математику", MainActivity.createAccessIndicatorForEvent(3)));
}


    @Override
    protected void onStart() {
        super.onStart();
    }
}