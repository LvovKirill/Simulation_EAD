package com.example.simulation_ead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FriendsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_research_frieds;
    LinearLayout layout_view_friends;
    FrameLayout anim_friend_container;

    int count_person = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btn_research_frieds = (Button)findViewById(R.id.btn_research_frieds);
        layout_view_friends = (LinearLayout) findViewById(R.id.layout_view_friends);
        anim_friend_container = (FrameLayout) findViewById(R.id.anim_friend_container);

        btn_research_frieds.setOnClickListener(this);

        // получаем экземпляр FragmentTransaction

    }


    Friend mas[] = {
            new Friend(R.drawable.misha_portn, "Миша Портнов", "Android-разработка", R.drawable.ic_hamburger, "+ 10 к организовать IT школу Sumsung"),
            new Friend(R.drawable.ana_buchinskaya, "Аня Бучинская", "Хакер", R.drawable.ic_calculator, "+ 18 к организовать ПП"),
            new Friend(R.drawable.misha_portn, "Миша Портнов", "Android-разработка", R.drawable.ic_atom, "+ 10 к организовать IT школу Sumsung"),
            new Friend(R.drawable.adelya_hasanova, "Аделя Хасанова", "Искуственный интеллект", R.drawable.ic_neuro_net, "+ 15 к написать нейросеть"),
            new Friend(R.drawable.image_lvl_4, "Михаил Портнов", "Android-разработка", R.drawable.ic_atom, "R.string.Mihail_Prt"),
            new Friend(R.drawable.image_lvl_5, "Михаил Портнов", "Android-разработка", R.drawable.ic_hamburger, "R.string.Mihail_Prt"),
            new Friend(R.drawable.image_lvl_6, "Михаил Портнов", "Android-разработка", R.drawable.ic_hamburger, "R.string.Mihail_Prt")
    };

    int mas_zapis[] = new int [mas.length];




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_research_frieds:
                if (count_person+1<mas.length) {

                    int number_person;
                    boolean znach = true;

                    do {
                        number_person = (int) getRandomNumber(mas.length-1, 0);

                        for (int i = 0; i < mas_zapis.length; i++) {
                            if (mas_zapis[i] == number_person){
                                znach = false;
                                break;
                            }else znach = true;
                        }
                    }while (znach == false);

                    mas_zapis[count_person] = number_person;

//                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.anim_friend_container, new NewFriendAnimFragment());
//                    fragmentTransaction.commit();


                    final View view = getLayoutInflater().inflate(R.layout.friend_list_item, null);
                    ImageView image_person = (ImageView) view.findViewById(R.id.image_person);
                    ImageView talent = (ImageView) view.findViewById(R.id.talent);
                    TextView talent_str = (TextView) view.findViewById(R.id.talent_str);
                    TextView name = (TextView) view.findViewById(R.id.name);
                    TextView subscribe = (TextView) view.findViewById(R.id.subscribe);

                    image_person.setImageResource(mas[number_person].image_person);
                    talent.setImageResource(mas[number_person].image_talent);
                    talent_str.setText(mas[number_person].talent);
                    name.setText(mas[number_person].name);
                    subscribe.setText(mas[number_person].subsctibe);

                    layout_view_friends.addView(view);

                    count_person++;
                }else{
                    Toast.makeText(this, "Вы нашли всех друзей", Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }


    public static double getRandomNumber(int max, int min){
        double x = (Math.random() * ((max - min) + 1)) + min;
        return x;
    }
}