package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FriendsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_research_frieds;
    LinearLayout layout_view_friends;
    Fragment fragment;

    int count_person = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btn_research_frieds = (Button)findViewById(R.id.btn_research_frieds);
        layout_view_friends = (LinearLayout) findViewById(R.id.layout_view_friends);

        btn_research_frieds.setOnClickListener(this);
    }


    Friend mas[] = {
            new Friend(R.drawable.image_lvl_1, "Михаил Портнов", "Android-разработка", R.drawable.ic_hamburger, "R.string.Portnov"),
            new Friend(R.drawable.image_lvl_2, "Михаил Портнов", "Хакер", R.drawable.ic_calculator, "R.string.Portnov"),
            new Friend(R.drawable.image_lvl_3, "Михаил Портнов", "Искуственный интеллект", R.drawable.ic_computer, "R.string.Portnov"),
            new Friend(R.drawable.image_lvl_4, "Михаил Портнов", "Android-разработка", R.drawable.ic_atom, "R.string.Portnov"),
            new Friend(R.drawable.image_lvl_5, "Михаил Портнов", "Android-разработка", R.drawable.ic_hamburger, "R.string.Portnov"),
            new Friend(R.drawable.image_lvl_6, "Михаил Портнов", "Android-разработка", R.drawable.ic_hamburger, "R.string.Portnov")
    };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_research_frieds:
                if (count_person<mas.length) {
                    final View view = getLayoutInflater().inflate(R.layout.friend_list_item, null);
                    ImageView image_person = (ImageView) view.findViewById(R.id.image_person);
                    ImageView talent = (ImageView) view.findViewById(R.id.talent);
                    TextView talent_str = (TextView) view.findViewById(R.id.talent_str);
                    TextView subscribe = (TextView) view.findViewById(R.id.subscribe);

                    image_person.setImageResource(mas[count_person].image_person);
                    talent.setImageResource(mas[count_person].image_talent);
                    talent_str.setText(mas[count_person].talent);
                    subscribe.setText(mas[count_person].subsctibe);

                    layout_view_friends.addView(view);

                    count_person++;
                }

                break;
        }

    }
}