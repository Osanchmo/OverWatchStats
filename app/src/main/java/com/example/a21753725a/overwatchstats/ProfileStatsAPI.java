package com.example.a21753725a.overwatchstats;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileStatsAPI {

    String PROF_URL;
    String HERO_URL;

    public ProfileStatsAPI(String PROF_URL, String HERO_URL) {
        this.PROF_URL = PROF_URL;
        this.HERO_URL = HERO_URL;
    }

    public ProfileStat getStats() {
    //BASE_URL = "https://api.lootbox.eu/pc/eu/EVERMORE-31643/profile";

        Uri builtUri = Uri.parse(PROF_URL)
                .buildUpon()
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    @Nullable
    private ProfileStat doCall(String url) {
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
    private ProfileStat processJson(String jsonResponse) {

        ProfileStat ps = new ProfileStat();
        try {
            JSONObject objct = new JSONObject(jsonResponse);
            JSONObject aux;

            ps.setUsername(objct.getString("username"));
            ps.setLevel(String.valueOf(objct.getString("level")));

            aux = objct.getJSONObject("games");
            ps.setQuickGameWins(aux.getJSONObject("quickplay").getString("wins"));
            String[] strings = new String[3];
                strings[0] = aux.getJSONObject("competitive").getString("wins");
                strings[2] = aux.getJSONObject("competitive").getString("played");
                strings[1] = String.valueOf(Integer.valueOf(strings[2]) - Integer.valueOf(strings[0]));

            ps.setCompetitive(strings);
            aux = objct.getJSONObject("playtime");
            strings = new String[2];
                strings[0] = aux.getString("quickplay");
                strings[1] = aux.getString("competitive");
            ps.setPlayTime(strings);

            ps.setAvatar(objct.getString("portrait"));
            ps.setLevelFrame(objct.getString("levelFrame"));
            ps.setStar(objct.getString("star"));

            aux = objct.getJSONObject("competitive");
            ps.setRank(aux.getString("rank"));
            ps.setRankImg(aux.getString("rank_img"));

            HeroesAPI heroes = new HeroesAPI();
            ps.setHeroes(heroes.getStats(HERO_URL));

        } catch (JSONException e) {
            ps  = null;
            System.out.println(e);
        }
        return ps;
    }
}



