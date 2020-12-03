package com.example.simulation_ead;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

import static com.example.simulation_ead.R.raw.sound_rest;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static TextView textView;
    public static ImageView imageView;
    public static ImageView imageView_background;
    public static CardView cardView;
    public static int lvl = 1;
    private ImageButton btn_admob_smile;

    public static SharedPreferences sharedPreferences_brain;
    public static SharedPreferences sharedPreferences_rest;
    public static SharedPreferences sharedPreferences_affairs;
    public static SharedPreferences sharedPreferences_progressbar_lvl;
    public static SharedPreferences sharedPreferences_lvl;

    private MediaPlayer sound;
    private RewardedAd rewardedAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_mind = (Button)findViewById(R.id.btn_mind);
        Button btn_happiness = (Button)findViewById(R.id.btn_happiness);
        Button btn_affairs = (Button)findViewById(R.id.btn_affairs);

        ImageButton btn_settings = (ImageButton)findViewById(R.id.btn_settings);
        ImageButton btn_shop = (ImageButton)findViewById(R.id.btn_shop);
        ImageButton btn_friends = (ImageButton)findViewById(R.id.btn_friends);

//        Button advertising_smile = (Button)findViewById(R.id.advertising_smile);

        btn_admob_smile = (ImageButton)findViewById(R.id.advertising_smile);

        textView = (TextView)findViewById(R.id.textView);
        imageView = (ImageView)findViewById(R.id.image_lvl);
        imageView_background = (ImageView)findViewById(R.id.image_background);
        cardView = (CardView) findViewById(R.id.imageView);

        btn_mind.setOnClickListener(this);
        btn_happiness.setOnClickListener(this);
        btn_affairs.setOnClickListener(this);

        btn_settings.setOnClickListener(this);
        btn_shop.setOnClickListener(this);
        btn_friends.setOnClickListener(this);
        btn_admob_smile.setOnClickListener(this);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus){

            }
        });



        rewardedAd = new RewardedAd(this,
                "ca-app-pub-3940256099942544/5224354917");

        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
            @Override
            public void onRewardedAdLoaded() {
                // Ad successfully loaded.
            }

            @Override
            public void onRewardedAdFailedToLoad(int i) {
                super.onRewardedAdFailedToLoad(i);
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }



    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btn_mind:
                Intent mind = new Intent(MainActivity.this, MindActivity.class);
                startActivity(mind);
                break;
            case R.id.btn_happiness:
                Intent happiness = new Intent(MainActivity.this, RestActivity.class);
                startActivity(happiness);
                break;
            case R.id.btn_affairs:
                Intent affairs = new Intent(MainActivity.this, AffairsActivity.class);
                startActivity(affairs);
                break;
            case R.id.btn_settings:
                Intent settings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(settings);
                break;
            case R.id.btn_shop:
                Intent shop = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(shop);
                break;
            case R.id.btn_friends:
                if (lvl>2) {
                    Intent friends = new Intent(MainActivity.this, FriendsActivity.class);
                    startActivity(friends);
                }else{
                    Toast.makeText(this, "Требуется уровень 3", Toast.LENGTH_SHORT).show();

                    Animation animRotateIn_big = AnimationUtils.loadAnimation(this, R.anim.shake_up);
                    btn_admob_smile.startAnimation(animRotateIn_big);
                }
                break;
            case R.id.advertising_smile:

                if (rewardedAd.isLoaded()) {
                    Activity activityContext = MainActivity.this;
                    RewardedAdCallback adCallback = new RewardedAdCallback() {
                        @Override
                        public void onRewardedAdOpened() {
                            // Ad opened.
                        }

                        @Override
                        public void onRewardedAdClosed() {
                            Toast.makeText(activityContext, "Досмотрите видео до конца", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onUserEarnedReward(@NonNull RewardItem reward) {

                            CustomToast.makeText(activityContext, "Повышен уровень счастья", Toast.LENGTH_SHORT, 1, R.drawable.ic_smiling).show();


                            rewardedAd = new RewardedAd(activityContext,
                                    "ca-app-pub-3940256099942544/5224354917");

                            RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {
                                @Override
                                public void onRewardedAdLoaded() {
                                    // Ad successfully loaded.
                                }

                                @Override
                                public void onRewardedAdFailedToLoad(int i) {
                                    super.onRewardedAdFailedToLoad(i);
                                }
                            };
                            rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
                        }

                        @Override
                        public void onRewardedAdFailedToShow(int i) {
                            super.onRewardedAdFailedToShow(i);
                        }
                    };
                    rewardedAd.show(activityContext, adCallback);


                } else {
                    Toast.makeText(this, " uuuu", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "The rewarded ad wasn't loaded yet.");
                }
                break;

        }


        }



    static Level mas_lvl[] = {
            new Level(1, R.drawable.image_lvl_1, 10, R.drawable.lyzey_photo, "10 класс"),
            new Level(2, R.drawable.image_lvl_2, 8, R.drawable.lyzey_photo, "11 класс"),
            new Level(3, R.drawable.image_lvl_3, 6, R.drawable.miphi_photo2, "Бакалавр МИФИ 1"),
            new Level(4, R.drawable.image_lvl_4, 4, R.drawable.miphi_photo2, "Бакалавр МИФИ 2"),
            new Level(5, R.drawable.image_lvl_5, 4, R.drawable.miphi_photo, "Магистр МИФИ 1"),
            new Level(6, R.drawable.image_lvl_6, 4, R.drawable.miphi_photo, "Магистр МИФИ 2"),
            new Level(7, R.drawable.image_lvl_7, 4, R.drawable.miphi_photo, "Аспирант МИФИ 1"),
            new Level(8, R.drawable.image_lvl_8, 4, R.drawable.miphi_photo, "Аспирант МИФИ 2"),
            new Level(9, R.drawable.image_lvl_9, 4, R.drawable.miphi_photo, "Крутой"),
            new Level(10, R.drawable.image_lvl_10, 4, R.drawable.miphi_photo, "Super-крутой"),
    };

    public static void createLvl(){
        if (lvl>mas_lvl.length) {
            textView.setText(mas_lvl[mas_lvl.length - 1].name_lvl);
            imageView.setImageResource(mas_lvl[mas_lvl.length - 1].image_lvl);
            imageView_background.setImageResource(mas_lvl[mas_lvl.length - 1].background_lvl);
        }else{
            textView.setText(mas_lvl[lvl - 1].name_lvl);
            imageView.setImageResource(mas_lvl[lvl - 1].image_lvl);
            imageView_background.setImageResource(mas_lvl[lvl - 1].background_lvl);
            StatusFragment.textView_lvl.setText(Integer.valueOf(lvl - 1).toString());
        }


//        StatusFragment.progress_mind = 100;
//        StatusFragment.progress_rest = 100;
//        StatusFragment.progress_affairs = 100;
//        StatusFragment.progress_lvl = 0;
    }

    public static void moneyLvl(){
        StatusFragment.linearLayout.removeAllViews();
    }

    public static void newLvl(){
        lvl += 1;
        if (lvl>mas_lvl.length){
            moneyLvl();
        }else{
        textView.setText(mas_lvl[lvl-1].name_lvl);
        imageView.setImageResource(mas_lvl[lvl-1].image_lvl);
        imageView_background.setImageResource(mas_lvl[lvl-1].background_lvl);
        StatusFragment.textView_lvl.setText(Integer.valueOf(lvl).toString());
        StatusFragment.progress_mind = 100;
        StatusFragment.progress_rest = 100;
        StatusFragment.progress_affairs = 100;
        StatusFragment.progress_lvl = 0;
        }
    }


    public static void restartGame(){
        lvl = 1;
        textView.setText(mas_lvl[lvl-1].name_lvl);
        imageView.setImageResource(mas_lvl[lvl-1].image_lvl);
        imageView_background.setImageResource(mas_lvl[lvl-1].background_lvl);
        StatusFragment.textView_lvl.setText(Integer.valueOf(lvl).toString());
        StatusFragment.progress_mind = 100;
        StatusFragment.progress_rest = 100;
        StatusFragment.progress_affairs = 100;
        StatusFragment.progress_lvl = 0;
    }


    public void recreate(){
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        overridePendingTransition(0, 0);
    }

    public static boolean createAccessIndicatorForEvent(int lvl){
     if (MainActivity.lvl<lvl)
         return false;
     else
         return true;
    }

    @Override
    protected void onStart() {
        loadParams();
        createLvl();
//        Intent questionIntent = new Intent(MainActivity.this,
//                MindActivity.class);
//        startActivityForResult(questionIntent, 5;
//        overridePendingTransition(R.anim.diagonaltranslate,R.anim.alpha);

//        Slide slide = new Slide();
//        slide.setDuration(1000);
//        getWindow().setExitTransition(slide);
        super.onStart();
    }

    @Override
    protected void onRestart() {
        finish();
        startActivity(getIntent());
//        overridePendingTransition(R.anim.diagonaltranslate, R.anim.diagonaltranslate);
        Slide slide = new Slide();
        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        Animation animRotateIn_big = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        cardView.startAnimation(animRotateIn_big);
    }



    private void loadParams() {
        sharedPreferences_brain = getPreferences(MODE_PRIVATE);
        StatusFragment.progress_mind = sharedPreferences_brain.getInt("progressbar_brain", 0);
        StatusFragment.setProgress_mind();

        sharedPreferences_rest = getPreferences(MODE_PRIVATE);
        StatusFragment.progress_rest = sharedPreferences_rest.getInt("progressbar_rest", 0);
        StatusFragment.setProgress_rest();

        sharedPreferences_affairs = getPreferences(MODE_PRIVATE);
        StatusFragment.progress_affairs = sharedPreferences_affairs.getInt("progressbar_affairs", 0);
        StatusFragment.setProgress_affairs();

        sharedPreferences_progressbar_lvl = getPreferences(MODE_PRIVATE);
        StatusFragment.progress_lvl = sharedPreferences_progressbar_lvl.getInt("progressbar_progressbar_lvl", 0);
        StatusFragment.setProgress_lvl();


//        sharedPreferences_lvl = getPreferences(MODE_PRIVATE);
//        MainActivity.lvl = sharedPreferences_lvl.getInt("progressbar_lvl", 1);

//        StatusFragment.setProgress_lvl();

//        sharedPreferences_lvl = getPreferences(MODE_PRIVATE);
//        MainActivity.lvl = Integer.parseInt (sharedPreferences_lvl.getString("progressbar_lvl", "1"));
//        StatusFragment.textView_lvl.setText(sharedPreferences_lvl.getString("progressbar_lvl", "1"));

    }
}
