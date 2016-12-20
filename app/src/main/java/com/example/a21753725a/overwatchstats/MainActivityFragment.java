package com.example.a21753725a.overwatchstats;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


public class MainActivityFragment extends Fragment {

    View view;
    Spinner platform;
    Spinner region;

    public MainActivityFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        platform = (Spinner) view.findViewById(R.id.platform);
        platform.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectPlatform(i);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        region = (Spinner) view.findViewById(R.id.region);
        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectRegion(i);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        return view;
    }

    private static void selectPlatform(int i){
        switch (i){
            case 0:
                System.out.println("PC SELECTED");
                break;
            case 1:
                System.out.println("PS4 SELECTED");
                break;
            case 2:
                System.out.println("XBOX ONE SELECTED");
                break;
        }
    }

    private static void selectRegion(int i){
        switch (i){
            case 0:
                //do
                break;
            case 1:
                //do
                break;
            case 2:
                //do
                break;
            case 3:
                //do
                break;
            case 4:
                //do
                break;
        }
    }

}
