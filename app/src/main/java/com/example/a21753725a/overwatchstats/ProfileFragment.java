package com.example.a21753725a.overwatchstats;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ProfileFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        ProfileStat stat = null;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                stat = null;
            } else {
                stat = (ProfileStat) savedInstanceState.getSerializable("stat");
            }
        }
        statAdapter(stat);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private static void statAdapter(ProfileStat stat){


    }


}