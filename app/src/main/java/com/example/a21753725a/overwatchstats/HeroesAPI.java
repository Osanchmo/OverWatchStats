package com.example.a21753725a.overwatchstats;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class HeroesAPI {

    public ArrayList<Hero> getStats(String BASE_URL) {

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    @Nullable
    private ArrayList<Hero> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Recoge las cartas de una API y almacena datos en un array de objetos carta
     * con los datos que queremos guardar
     *
     * @param jsonResponse
     * @return
     */
    private ArrayList<Hero> processJson(String jsonResponse) {
        ArrayList<Hero> heroes = new ArrayList<>();



        try {
            JSONObject objct = new JSONObject(jsonResponse);
            JSONObject stats = objct.getJSONObject("stats");
            JSONObject topHeroes = stats.getJSONObject("top_heroes");
            JSONArray comp = topHeroes.getJSONArray("competitive");

            for (int i = 0; i < comp.length(); i++) {

                JSONObject obj = comp.getJSONObject(i);
                Hero hero = new Hero(obj.getString("hero"),obj.getString("played"),obj.getString("img"));
                heroes.add(hero);
            }


        } catch (JSONException e) {
            heroes  = null;
            System.out.println(e);
        }
        return heroes;
    }
}



