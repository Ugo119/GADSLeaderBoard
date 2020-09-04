package com.ugo.android.gadsleaderboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.adapter.LeadersAdapter;

public class GadsHomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    LeadersAdapter leadersAdapter;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gads_pager);
        // Create an adapter that knows which fragment should be shown on each page
        leadersAdapter = new LeadersAdapter(this, getSupportFragmentManager());

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(mViewPager);

        // Find the view pager that will allow the user to swipe between fragments
        mViewPager = findViewById(R.id.gads_view_pager);

        // Set the adapter onto the view pager
        mViewPager.setAdapter(leadersAdapter);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.submit:
                fragmentManager = getSupportFragmentManager();


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}

