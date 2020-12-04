package com.example.simulation_ead;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class StatusFragment extends Fragment {

    public static ProgressBar progressbar_mind;
    public static ProgressBar progressbar_rest;
    public static ProgressBar progressbar_affairs;
    public static LinearLayout linearLayout;
    public static ProgressBar progressbar_lvl;
    public static TextView textView_lvl;


    public static ImageView imageView_progress_brain;
    public static ImageView imageView_progress_rest;
    public static ImageView imageView_progress_affairs;

    private static MindActivity mindActivity;
    Handler handler = new Handler();


    public static int progress_mind = 100;
    public static int progress_rest = 100;
    public static int progress_affairs = 100;
    public static int progress_lvl = 0;


    public static void setProgress_mind() {
        progressbar_mind.setProgress(progress_mind);
    }
    public static void setProgress_rest() {
        progressbar_rest.setProgress(progress_rest);
    }
    public static void setProgress_affairs() {
        progressbar_affairs.setProgress(progress_affairs);
    }
    public static void setProgress_lvl() {
        progressbar_lvl.setProgress(progress_lvl);
    }
    public static void set_lvl(String lvl) {
        textView_lvl.setText(lvl);
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_status, container, false);

        progressbar_mind = (ProgressBar)rootView.findViewById(R.id.progress_mind);
        progressbar_rest = (ProgressBar)rootView.findViewById(R.id.progress_rest);
        progressbar_affairs = (ProgressBar)rootView.findViewById(R.id.progress_affairs);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.deleted_progress_layout);


        imageView_progress_brain = (ImageView) rootView.findViewById(R.id.icon_brain);
        imageView_progress_rest = (ImageView) rootView.findViewById(R.id.icon_rest);
        imageView_progress_affairs = (ImageView) rootView.findViewById(R.id.icon_affairs);

        progressbar_mind.setProgress(progress_mind);
        progressbar_rest.setProgress(progress_rest);
        progressbar_affairs.setProgress(progress_affairs);

        if(MainActivity.lvl<=MainActivity.mas_lvl.length) {
            progressbar_lvl = (ProgressBar)rootView.findViewById(R.id.progress_lvl);
            textView_lvl = (TextView)rootView.findViewById(R.id.lvl);

            progressbar_lvl.setProgress(progress_lvl);
            textView_lvl.setText(Integer.valueOf(MainActivity.lvl).toString());
        }

        return rootView;
    }



//    public void progress_make() {

//        progressbar_mind = (ProgressBar)rootView.findViewById(R.id.progress_mind);
//        progressbar_rest = (ProgressBar)rootView.findViewById(R.id.progress_rest);
//        progressbar_affairs = (ProgressBar)rootView.findViewById(R.id.progress_affairs);

//    }


//    public void progress_make(int change_mind, int change_rest, int change_affairs) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (progress_mind < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    progressbar_mind.setProgress(progress_mind);
//                }
//            });
//            progress_mind += change_mind;
//        }
//
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (progress_rest < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    progressbar_rest.setProgress(progress_rest);
//                }
//            });
//            progress_rest += change_rest;
//        }
//
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (progress_affairs < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    progressbar_affairs.setProgress(progress_affairs);
//                }
//            });
//            progress_affairs += change_affairs;
//        }
//
//                }
//            }).start();
//    }


    @Override
    public  void onStart() {
        super.onStart();
    }
}