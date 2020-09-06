package com.ugo.android.gadsleaderboard.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ugo.android.gadsleaderboard.R;
import com.ugo.android.gadsleaderboard.adapter.LeadersAdapter;

public class GadsHomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private LeadersAdapter leadersAdapter;
    private ImageView menuSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gads_pager);
        leadersAdapter = new LeadersAdapter(this, getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        tabLayout.setupWithViewPager(mViewPager);

        mViewPager = findViewById(R.id.gads_view_pager);

        mViewPager.setAdapter(leadersAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        menuSubmit = findViewById(R.id.btn_submit);
        menuSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GadsHomeActivity.this, SubmitActivity.class);
                startActivity(intent);
            }
        });
    }

}

