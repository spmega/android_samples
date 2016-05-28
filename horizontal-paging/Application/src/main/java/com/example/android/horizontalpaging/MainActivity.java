package com.example.android.horizontalpaging;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    static final int NUM_ITEMS = 10;

    MyAdapter mAdapter;

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager);
        final Toast warning = Toast.makeText(this, "No more fragments!", Toast.LENGTH_SHORT);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mAdapter = new MyAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        tabLayout.setupWithViewPager(mPager);

        // Watch for button clicks.
        Button button = (Button) findViewById(R.id.goto_first);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mPager.getCurrentItem() == 0){
                    warning.show();
                } else{
                    mPager.setCurrentItem(mPager.getCurrentItem()-1);
                }
            }
        });

        button = (Button) findViewById(R.id.goto_last);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mPager.getCurrentItem() == (NUM_ITEMS-1)){
                    warning.show();
                } else {
                    mPager.setCurrentItem(mPager.getCurrentItem()+1);
                }
            }
        });
    }
}