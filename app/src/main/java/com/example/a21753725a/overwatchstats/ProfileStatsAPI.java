package com.example.a21753725a.overwatchstats;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileStatsAPI {

    public static ArrayList<ProfileStat> getStats(String BASE_URL) {
    BASE_URL = "https://api.lootbox.eu/pc/eu/EVERMORE-31643/profile";

        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    @Nullable
    private static ArrayList<ProfileStat> doCall(String url) {
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
    private static ArrayList<ProfileStat> processJson(String jsonResponse) {

        ArrayList<ProfileStat> stats = new ArrayList<>();

        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray jsonStats = data.getJSONArray("data");

            for (int i = 0; i < jsonStats.length(); i++) {

                JSONObject jsonStat = jsonStats.getJSONObject(i);

                ProfileStat ps = new ProfileStat();

                ps.setUsername(jsonStat.getString("username"));

                System.out.println(ps.username);


              /*  Card carta = new Card();

                carta.setName(jsonCard.getString("name"));
                carta.setRarity(jsonCard.getString("rarity"));
                carta.setType(jsonCard.getString("type"));
                carta.setImagen(jsonCard.getString("imageUrl"));

                if (jsonCard.has("text")) carta.setTexto(jsonCard.getString("text"));
                if (jsonCard.has("toughness"))
                    carta.setResistencia(jsonCard.getString("toughness"));
                if (jsonCard.has("power")) carta.setFuerza(jsonCard.getString("power"));
                if (jsonCard.has("colors")) carta.setColores(jsonCard.getString("colors"));

                cartas.add(carta);*/
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return stats;
    }
}



