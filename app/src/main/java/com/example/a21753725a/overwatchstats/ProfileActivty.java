package com.example.a21753725a.overwatchstats;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class ProfileActivty extends AppCompatActivity {
    static ProfileStat stat;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_activty);

        stat = (ProfileStat) getIntent().getSerializableExtra("stat");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance() {
            PlaceholderFragment fragment = new PlaceholderFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_profile_activty, container, false);

            TextView username = (TextView) rootView.findViewById(R.id.userName);
            username.setText(stat.getUsername());
            TextView rank = (TextView) rootView.findViewById(R.id.rank);
            rank.setText(stat.getRank());

            TextView played = (TextView) rootView.findViewById(R.id.playedN);
            played.setText(stat.getCompetitive(2));
            TextView won = (TextView) rootView.findViewById(R.id.winN);
            won.setText(stat.getCompetitive(0));
            TextView lost = (TextView) rootView.findViewById(R.id.lostN);
            lost.setText(stat.getCompetitive(1));

            TextView quickWins = (TextView) rootView.findViewById(R.id.quickWonGames);
            quickWins.setText(stat.getQuickGameWins());
            TextView quickPlayTime = (TextView) rootView.findViewById(R.id.qPlayTime);
            quickPlayTime.setText(stat.getPlayTime(0));
            TextView rankPlayTime = (TextView) rootView.findViewById(R.id.rPlayTime);
            rankPlayTime.setText(stat.getPlayTime(1));

            ImageView rankImg = (ImageView) rootView.findViewById(R.id.rankImg);
            Glide.with(this).load(stat.getRankImg()).into(rankImg);

            ImageView avatarImg = (ImageView) rootView.findViewById(R.id.avatarImg);
            Glide.with(this).load(stat.getAvatar()).bitmapTransform(new CropCircleTransformation(this.getContext())).into(avatarImg);

            ImageView borderImg = (ImageView) rootView.findViewById(R.id.borderImg);
            Glide.with(this).load(stat.getLevelFrame()).into(borderImg);

            ImageView starImg = (ImageView) rootView.findViewById(R.id.star);
            Glide.with(this).load(stat.getStar()).into(starImg);


            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return PlaceholderFragment.newInstance();
                case 1:
                    return HeroStatsTime.newInstance(stat);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }


       /** @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }**/
    }
}
