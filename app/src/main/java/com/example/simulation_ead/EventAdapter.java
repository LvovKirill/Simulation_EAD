package com.example.simulation_ead;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.simulation_ead.R.drawable.background_lvl_style;

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

        ((ImageView) view.findViewById(R.id.imageEvant)).setImageResource(p.icon_event);
        ((TextView) view.findViewById(R.id.textEvant)).setText(p.event);
        ((Button) view.findViewById(R.id.btn_make)).setText(createTextForEventButton(p.status));
//        ((Button) view.findViewById(R.id.btn_make)).setBackgroundColor(createBackgroundForEventButton(p.status));
        ((Button) view.findViewById(R.id.btn_make)).setTextColor(createBackgroundForEventButton(p.status));



if (p.status == true) {
    Button button = (Button) view.findViewById(R.id.btn_make);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            int mind = p.getMind();
            int happiness = p.getHappiness();
            int requirements = p.getRequirements();

            StatusFragment.progress_mind += mind;
            StatusFragment.progress_rest += happiness;
            StatusFragment.progress_affairs += requirements;
            StatusFragment.progress_lvl += MainActivity.mas_lvl[MainActivity.lvl - 1].move_lvl;

            StatusFragment.setProgress_mind();
            StatusFragment.setProgress_rest();
            StatusFragment.setProgress_affairs();
            StatusFragment.setProgress_lvl();

//                Fragment fragment_status = new StatusFragment();
//                final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.mind_status_container, fragment_status);
//                transaction.commit();


            if (StatusFragment.progress_lvl >= 100) {
                MainActivity.newLvl();

                StatusFragment.setProgress_mind();
                StatusFragment.setProgress_rest();
                StatusFragment.setProgress_affairs();
                StatusFragment.setProgress_lvl();
            }
            if (StatusFragment.progress_mind <= 0 || StatusFragment.progress_rest <= 0 || StatusFragment.progress_affairs <= 0) {
                MainActivity.restartGame();

                StatusFragment.setProgress_mind();
                StatusFragment.setProgress_rest();
                StatusFragment.setProgress_affairs();
                StatusFragment.setProgress_lvl();
            }

        }
    });
}else if (p.status == false){
    Button button = (Button) view.findViewById(R.id.btn_make);
//    button.setBackgroundColor(button.getContext().getResources().getColor(R.color.button_false));
//    button.setBackground(button.getContext().getResources().getDrawable(background_lvl_style));
//    button.setLinkTextColor(button.getContext().getResources().getColor(R.color.black));
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {}
    });

}


        return view;
    }

    public String createTextForEventButton(boolean status){
        if (status == true)
            return "Сделать";
        else
            return "Замок";
    }

    public int createColorTextForEventButton(boolean status){
        if (status == true)
            return Color.parseColor("orange");
        else
            return Color.parseColor("gray");
    }

    public int createBackgroundForEventButton(boolean status){
        if (status == true)
            return Color.parseColor("white");
        else
            return Color.parseColor("black");
    }

    Event getEvent(int position) {
        return ((Event) getItem(position));
    }


}
