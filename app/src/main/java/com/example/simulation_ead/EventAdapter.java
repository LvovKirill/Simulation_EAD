package com.example.simulation_ead;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Event> objects;

    public ArrayList<Event> getObjects() {
        return objects;
    }

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
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.list_item, parent, false);
        }

        Event p = getEvent(position);

        ((ImageView) view.findViewById(R.id.imageEvant)).setImageResource(R.drawable.ic_home_and_money);
        ((TextView) view.findViewById(R.id.textEvant)).setText(p.event);



        Button button = (Button) view.findViewById(R.id.btn_make);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int mind = p.getMind();
                int happiness = p.getHappiness();
                int requirements = p.getRequirements();

                StatusFragment.progress_mind += mind;
                StatusFragment.progress_rest += happiness;
                StatusFragment.progress_affairs += requirements;
                StatusFragment.progress_lvl += 2;

                StatusFragment.setProgress_mind();
                StatusFragment.setProgress_rest();
                StatusFragment.setProgress_affairs();
                StatusFragment.setProgress_lvl();

                if(StatusFragment.progress_lvl==100){
                    MainActivity.newLvl();
                }
                if (StatusFragment.progress_mind<=0 || StatusFragment.progress_rest<=0 || StatusFragment.progress_affairs<=0){
                    MainActivity.restartGame();

                    StatusFragment.setProgress_mind();
                    StatusFragment.setProgress_rest();
                    StatusFragment.setProgress_affairs();
                    StatusFragment.setProgress_lvl();
                }

            }
        });


        return view;
    }

    Event getEvent(int position) {
        return ((Event) getItem(position));
    }


}
