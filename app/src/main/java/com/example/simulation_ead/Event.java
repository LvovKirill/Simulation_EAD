package com.example.simulation_ead;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Event{
    int mind;
    int rest;
    int happiness;
    int lvl_access;
    int icon_event;
    int categoty;
    // 1-ум 2-отдых 3-дела
    String event;
    boolean status;

    public int getMind() {
        return mind;
    }

    public int getRequirements() {
        return rest;
    }

    public int getHappiness() {
        return happiness;
    }

    Event (int mind, int rest, int happiness, int lvl_access, int icon_event, int categoty, String event, boolean status){
        this.mind=mind;
        this.rest=rest;
        this.happiness=happiness;
        this.lvl_access=lvl_access;
        this.icon_event=icon_event;
        this.categoty=categoty;
        this.event=event;
        this.status = status;
    }

    Event(String event){
        this.event=event;
    }

}








//        public void progress_make(int change_mind, int change_rest, int change_affairs) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (StatusFragment.progress_mind < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    StatusFragment.progressbar_mind.setProgress(StatusFragment.progress_mind);
//                }
//            });
//            StatusFragment.progress_mind += change_mind;
//        }
//
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (StatusFragment.progress_rest < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    StatusFragment.progressbar_rest.setProgress(StatusFragment.progress_rest);
//                }
//            });
//            StatusFragment.progress_rest += change_rest;
//        }
//
//                }
//            }).start();
//
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//
//        while (StatusFragment.progress_affairs < 100) {
//            handler.post(new Runnable() {
//                @Override
//                public void run() {
//                    StatusFragment.progressbar_affairs.setProgress(StatusFragment.progress_affairs);
//                }
//            });
//            StatusFragment.progress_affairs += change_affairs;
//        }
//
//                }
//            }).start();
//    }
