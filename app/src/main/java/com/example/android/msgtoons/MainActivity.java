package com.example.android.msgtoons;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.example.android.msgtoons.fragments.ChannelFragment;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout = null;
    private ViewPager viewPager = null;
    String savedExtra;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        savedExtra = getIntent().getStringExtra("channel");
        System.out.println(savedExtra);
//        fragmentManager = getSupportFragmentManager();
//        Bundle bundle = new Bundle();
//
//        bundle.putString("edttext", savedExtra);
//        // set Fragmentclass Arguments
//        ChannelFragment fragobj = new ChannelFragment();
//        System.out.println(fragobj);
//        fragobj.setArguments(bundle);
//        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new ChannelFragment()).commit();

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        //setting the tabs title
        tabLayout.addTab(tabLayout.newTab().setText("Channel"));
        tabLayout.addTab(tabLayout.newTab().setText("PlayList"));
        tabLayout.addTab(tabLayout.newTab().setText("Live"));

        //setup the view pager
        final PagerAdapter adapter = new com.example.android.msgtoons.adapters.PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public String getMyData(){
        return savedExtra;
    }
}
