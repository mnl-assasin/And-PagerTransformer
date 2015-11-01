package com.neds.pagetransformer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
//        pager.setPageTransformer(false, new RotationPageTransformer(120));
        pager.setPageTransformer(false, new CardTransformer());
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {


        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;

            switch (i) {

                case 0:
                    fragment = new Fragment1();
                    break;
                case 1:
                    fragment = new Fragment2();
                    break;
                case 2:
                    fragment = new Fragment3();
                    break;


            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @SuppressLint("ValidFragment")
    public class Fragment1 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View v = inflater.inflate(R.layout.fragment1, container, false);
            return v;
        }
    }

    @SuppressLint("ValidFragment")
    public class Fragment2 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View v = inflater.inflate(R.layout.fragment2, container, false);
            return v;
        }
    }

    @SuppressLint("ValidFragment")
    public class Fragment3 extends Fragment {

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);

            View v = inflater.inflate(R.layout.fragment3, container, false);
            return v;
        }
    }
}
