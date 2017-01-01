package com.example.a21753725a.overwatchstats;

import android.net.Uri;
import android.support.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class ProfileStatsAPI {

    public ProfileStat getStats(String BASE_URL) {
    //BASE_URL = "https://api.lootbox.eu/pc/eu/EVERMORE-31643/profile";

        Uri builtUri = Uri.parse(BASE_URL)
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

        ProfileStat stat = new ProfileStat();

        try {
            JSONObject objct = new JSONObject(jsonResponse);
            JSONObject data = objct.getJSONObject("data");
            JSONObject aux;

            ProfileStat ps = new ProfileStat();
            ps.setUsername(data.getString("username"));
            ps.setLevel(String.valueOf(data.getString("level")));

            aux = data.getJSONObject("games");
            ps.setQuickGameWins(aux.getJSONObject("quick").getString("wins"));
            String[] strings = new String[3];
                strings[0] = aux.getJSONObject("competitive").getString("wins");
                strings[1] = aux.getJSONObject("competitive").getString("lost");
                strings[2] = aux.getJSONObject("competitive").getString("played");
            ps.setCompetitive(strings);
            aux = data.getJSONObject("playtime");
            strings = new String[2];
                strings[0] = aux.getString("quick");
                strings[1] = aux.getString("competitive");
            ps.setPlayTime(strings);

            ps.setAvatar(data.getString("avatar"));
            ps.setLevelFrame(data.getString("levelFrame"));
            ps.setStar(data.getString("star"));

            aux = data.getJSONObject("competitive");
            ps.setRank(aux.getString("rank"));
            ps.setRankImg(aux.getString("rank_img"));

            System.out.println(ps.getLevel());
            System.out.println(ps.getUsername());

        } catch (JSONException e) {
            stat  = null;
        }

        return stat;
    }
}



