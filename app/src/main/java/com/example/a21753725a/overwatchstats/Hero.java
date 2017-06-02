package com.example.a21753725a.overwatchstats;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by osanchmo on 26/05/2017.
 */

public class Hero implements Serializable {
    String name;
    String playtime;
    String path;

    public Hero(String name, String time, String path) {
        this.name = name;
        setPlaytime(time);
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String time) {

        Log.d(time, time);
        if (time.equals("--")){
            playtime = "0 minutes";
        } else {
            playtime = time;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
