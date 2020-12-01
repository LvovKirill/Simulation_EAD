package com.example.simulation_ead;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.simulation_ead.R.drawable.background_lvl_style;
import static com.example.simulation_ead.R.raw.sound_affairs;
import static com.example.simulation_ead.R.raw.sound_brain;
import static com.example.simulation_ead.R.raw.sound_game_over;
import static com.example.simulation_ead.R.raw.sound_rest;
import static com.example.simulation_ead.R.raw.sound_vin;

public class EventAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Event> objects;

    private MediaPlayer sound;

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

            if (StatusFragment.progress_mind+mind>100){
                StatusFragment.progress_mind = 100;}else  StatusFragment.progress_mind += mind;
            if (StatusFragment.progress_rest + happiness>100){
                StatusFragment.progress_rest =100;}else StatusFragment.progress_rest += requirements;
            if (StatusFragment.progress_affairs + requirements>100){
                StatusFragment.progress_affairs = 100;}else StatusFragment.progress_affairs += happiness;
            StatusFragment.progress_lvl += MainActivity.mas_lvl[MainActivity.lvl - 1].move_lvl;

            StatusFragment.setProgress_mind();
            StatusFragment.setProgress_rest();
            StatusFragment.setProgress_affairs();
            StatusFragment.setProgress_lvl();

                Animation animRotateIn_big = AnimationUtils.loadAnimation(ctx, R.anim.puls);
            if (p.categoty==1)
                StatusFragment.imageView_progress_brain.startAnimation(animRotateIn_big);
            if (p.categoty==2)
                StatusFragment.imageView_progress_rest.startAnimation(animRotateIn_big);
            if (p.categoty==3)
                StatusFragment.imageView_progress_affairs.startAnimation(animRotateIn_big);


            soundPlay(p.categoty);

//                Fragment fragment_status = new StatusFragment();
//                final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.add(R.id.mind_status_container, fragment_status);
//                transaction.commit();


            if (StatusFragment.progress_lvl >= 100) {
                MainActivity.newLvl();

                soundPlay(4);
                CustomToast.makeText(ctx, "Новый уровень", Toast.LENGTH_SHORT, 1, R.drawable.image_lvl_9).show();

                MindActivity.lvMain.clearChoices();


                StatusFragment.setProgress_mind();
                StatusFragment.setProgress_rest();
                StatusFragment.setProgress_affairs();
                StatusFragment.setProgress_lvl();
            }
            if (StatusFragment.progress_mind <= 0 || StatusFragment.progress_rest <= 0 || StatusFragment.progress_affairs <= 0) {
                MainActivity.restartGame();

                soundPlay(5);
                CustomToast.makeText(ctx, "Провал. Сложно быть Егоровым?", Toast.LENGTH_LONG, 1, R.drawable.game_over_photo).show();

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


    public void soundPlay(int category){
        if (category == 1) sound = MediaPlayer.create( this.ctx, sound_brain);
        if (category == 2) sound = MediaPlayer.create( this.ctx, sound_rest);
        if (category == 3) sound = MediaPlayer.create( this.ctx, sound_affairs);

        if (category == 4) sound = MediaPlayer.create( this.ctx, sound_vin);
        if (category == 5) sound = MediaPlayer.create( this.ctx, sound_game_over);

        sound.start();
    }



    public static int[] createPhotoForCustomeToast(){

        int [] result_mas = new int[3];
        int sch=0;

        int image_mas[][] = {
                {R.drawable.ic_atom, 1},
                {R.drawable.ic_atom, 1},
                {R.drawable.ic_atom, 1},
                {R.drawable.ic_atom, 2},
                {R.drawable.ic_atom, 2},
                {R.drawable.ic_atom, 2},
                {R.drawable.ic_atom, 3},
                {R.drawable.ic_atom, 3},
                {R.drawable.ic_atom, 3},
                {R.drawable.ic_atom, 4},
                {R.drawable.ic_atom, 4},
                {R.drawable.ic_atom, 4},
                {R.drawable.ic_atom, 5},
                {R.drawable.ic_atom, 5},
                {R.drawable.ic_atom, 5},
                {R.drawable.ic_atom, 6}
        };

        int lvl = MainActivity.lvl;

        for (int i = 0; i<image_mas.length; i++){
            if (image_mas[i][1]==lvl){
                result_mas[sch]=image_mas[i][0];
                sch++;
            }
        }
        return result_mas;
    }



    Event getEvent(int position) {
        return ((Event) getItem(position));
    }

}
