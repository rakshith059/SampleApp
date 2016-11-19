package com.example.sample.sampleapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.sample.sampleapp.adapter.PagerAdapter;
import com.example.sample.sampleapp.R;

//Implementing the interface OnTabSelectedListener to our MainActivity
//This interface would help in swiping views
public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing the tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.recommended)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.cravers)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.burgers)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getString(R.string.beverages)));
        //   Commented below line
        //  tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        final ViewPager viewPager = (ViewPager) findViewById(R.id.activity_view_pager);

        //Creating our pager adapter
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
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
}