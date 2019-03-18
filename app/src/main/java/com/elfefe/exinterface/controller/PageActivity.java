package com.elfefe.exinterface.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.elfefe.exinterface.R;
import com.elfefe.exinterface.controller.adapter.PageAdapter;

public class PageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page);

        this.configureViewPagerAndTab();
    }

    private void configureViewPagerAndTab(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_page_viewpager);
        TabLayout tab = (TabLayout) findViewById(R.id.activity_page_tab);

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),
                getResources().getIntArray(R.array.colorPagesViewPager)){});

        tab.setupWithViewPager(viewPager);

        tab.setTabMode(TabLayout.MODE_FIXED);
    }
}
