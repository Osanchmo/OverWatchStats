package com.example.a21753725a.overwatchstats;

import android.util.Log;

import java.io.Serializable;

/**
 * Created by osanchmo on 26/05/2017.
 */

public class Hero implements Serializable {
    String name;
    float playtime;
    String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPlaytime() {
        return playtime;
    }

    public void setPlaytime(String time) {

        Log.d(time, time);
        if (time.equals("--")){
            playtime = 0;
        } else {
            String[] tiempo = time.split(" ");

            if (tiempo[1].equals("minutes")) {
                playtime = Integer.valueOf(tiempo[0]) / 100;
            } else {
                playtime = Integer.valueOf(tiempo[0]);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
