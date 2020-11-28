package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;

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

// создаем адаптер
fillData();
eventAdapter = new EventAdapter(this, events);

// настраиваем список
ListView lvMain = (ListView) findViewById(R.id.listView_mind);
lvMain.setAdapter(eventAdapter);
}

// генерируем данные для адаптера
        void fillData() {

events.add(new Event("Product "));
events.add(new Event("Prrewre"));
events.add(new Event("Proerfrerfect "));
events.add(new Event("erwfwerf "));
events.add(new Event("Product "));
}
       // выводим информацию о корзине
//        public void showResult(View v) {
//String result = "Товары в корзине:";
//for (Event p : eventAdapter.getEvent()) {
//if (p.box)
//result += "\n" + p.event;
//}
//Toast.makeText(this, result, Toast.LENGTH_LONG).show();
//}

}