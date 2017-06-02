package com.example.a21753725a.overwatchstats;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by osanchmo on 26/05/2017.
 */

public class HEROAdapter extends ArrayAdapter<Hero> {

    public HEROAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Hero> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        Hero item = getItem(pos);



        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.hero_list_view, parent, false);

        }

        TextView tvHero = (TextView) convertView.findViewById(R.id.heroName);
        TextView tvPlayedTime = (TextView) convertView.findViewById(R.id.playedTime);

        ImageView imHero = (ImageView) convertView.findViewById(R.id.heroPortrait);

        tvHero.setText(item.getName());
        tvPlayedTime.setText(item.getPlaytime());
        Glide.with(getContext()).load(item.getPath()).into(imHero);
        return convertView;

    }

}
