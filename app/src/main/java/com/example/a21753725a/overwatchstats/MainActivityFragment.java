package com.example.a21753725a.overwatchstats;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivityFragment extends Fragment {

    String pl;
    String reg;
    String peticio;
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
        //obtenim el text escrit
        final EditText battleId = (EditText) view.findViewById(R.id.battleId);

        //llista d'items
        platform = (Spinner) view.findViewById(R.id.platform);
        platform.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //switch
                pl = selectPlatform(i,pl);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        region = (Spinner) view.findViewById(R.id.region);
        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reg = selectRegion(i,reg);
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        final Button button = (Button) view.findViewById(R.id.sendData);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String bId =  battleId.getText().toString();
                //todo change # for - from battleNetID
            peticio = "https://api.lootbox.eu/" + pl + "/" + reg + "/" + bId + "/profile";
            }
        });
        return view;
    }

    private static String selectPlatform(int i,String pl){
        switch (i){
            case 0:
                pl = "pc";
                break;
            case 1:
                pl = "ps4";
                break;
            case 2:
                pl = "xbl";
                break;
        }
        return pl;
    }

    private static String selectRegion(int i, String reg){
        switch (i){
            case 0:
                reg ="eu";
                break;
            case 1:
                reg = "us";
                break;
            case 2:
                reg = "kr";
                break;
            case 3:
                reg = "cn";
                break;
            case 4:
                reg = "global";
                break;
        }
        return reg;
    }



}
