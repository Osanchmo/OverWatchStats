package com.example.a21753725a.overwatchstats;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
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
    String heroPet;
    EditText battleId;

    public MainActivityFragment() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final Spinner platform;
        final Spinner region;

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        //obtenim el text escrit
        battleId = (EditText) view.findViewById(R.id.battleId);

        //llista d'items
        platform = (Spinner) view.findViewById(R.id.platform);
        platform.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //switch
                pl = selectPlatform(i, pl);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        region = (Spinner) view.findViewById(R.id.region);
        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reg = selectRegion(i, reg);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        final Button button = (Button) view.findViewById(R.id.sendData);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String bId = battleId.getText().toString();
                bId = bId.replace("#", "-");
                peticio = "http://ow-api.herokuapp.com/profile/" + pl + "/" + reg + "/" + bId;
                heroPet = "http://ow-api.herokuapp.com/stats/" + pl + "/" + reg + "/" + bId;
                getData();
            }
        });
        return view;
    }

    private String selectPlatform(int i, String pl) {
        switch (i) {
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

    private String selectRegion(int i, String reg) {
        switch (i) {
            case 0:
                reg = "eu";
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

    private void getData() {
        RefreshDataTask task = new RefreshDataTask();
        task.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void, Void, ProfileStat> {
        private ProgressDialog pDialog;
        @Override
        protected ProfileStat doInBackground(Void... voids) {

            ProfileStatsAPI api = new ProfileStatsAPI(peticio,heroPet);
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ProfileStat stat = api.getStats();

            return stat;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Cargando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected void onPostExecute(ProfileStat stat) {
            super.onPostExecute(stat);

            if (stat == null) {
                pDialog.dismiss();
                battleId.setError("Username not found");
            } else {
                pDialog.dismiss();
                Intent intent = new Intent(getContext(), ProfileActivty.class);
                intent.putExtra("stat",stat);
                startActivity(intent);
            }
        }
    }
}
