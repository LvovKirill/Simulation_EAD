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
    
EventAdapter eventAdapter;


public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_mind);

//    Fragment fragment_status = new StatusFragment();
//    final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.add(R.id.mind_status_container, fragment_status);
//    transaction.commit();


fillData();
eventAdapter = new EventAdapter(this, events);

ListView lvMain = (ListView) findViewById(R.id.listView_mind);
lvMain.setAdapter(eventAdapter);
}

        void fillData() {
events.add(new Event(10, -5, -5, 1, "Учить физку"));
events.add(new Event(10, -5, -5, 1, "Учить математику"));
events.add(new Event(10, -5, -5, 2, "Учить С++"));
events.add(new Event(10, -5, -5, 2, "Готовиться к ПКР"));
events.add(new Event(10, -5, -5, 2, "Готовиться к ЕГЭ"));
events.add(new Event(20, -5, -5, 3, "Учить высшую математику"));
}


}