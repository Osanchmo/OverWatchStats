package com.example.a21753725a.overwatchstats;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivityFragment extends Fragment {

    View view;
    Spinner platform;
    Spinner region;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        platform = spinnerAdapter(view.getContext(),platform,R.array.platform,R.id.region);
        region = spinnerAdapter(view.getContext(),region,R.array.region,R.id.region);

        return view;
    }

    private Spinner spinnerAdapter(Context cont, Spinner spinner,int arrayRef, int layoutRef ) {

        spinner = (Spinner) spinner.findViewById(R.id.region);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(cont, arrayRef, layoutRef);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return spinner;
    }
}
