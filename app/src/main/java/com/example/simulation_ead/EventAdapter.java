package com.example.simulation_ead;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButtonToggleGroup;

public class EventAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Event> objects;

    EventAdapter(Context context, ArrayList<Event> events) {
        ctx = context;
        objects = events;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }

        Event p = getEvent(position);

        ((ImageView) view.findViewById(R.id.imageEvant)).setImageResource(R.drawable.ic_home_and_money);
        ((TextView) view.findViewById(R.id.textEvant)).setText(p.event);

        Button button = (Button) view.findViewById(R.id.btn_make);
        button.setOnClickListener(myButtonClick);

        return view;
    }

    Event getEvent(int position) {
        return ((Event) getItem(position));
    }


//    ArrayList<Event> getEvent() {
//        ArrayList<Event> event = new ArrayList<Event>();
//        for (Event p : objects) {
//            // если в корзине
//            if (p.event)
//                event.add(p);
//        }
//        return event;
//    }

    // обработчик для чекбоксов

    View.OnClickListener myButtonClick = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
        }
    };

}
