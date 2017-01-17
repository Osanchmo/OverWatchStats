package com.example.a21753725a.overwatchstats;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeroStatsTime extends Fragment {

    View view;
    public HeroStatsTime() {
        // Required empty public constructor
    }
    public static HeroStatsTime newInstance(int sectionNumber) {
        HeroStatsTime fragment = new HeroStatsTime();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hero_stats_time, container, false);



        return view;
    }

}
