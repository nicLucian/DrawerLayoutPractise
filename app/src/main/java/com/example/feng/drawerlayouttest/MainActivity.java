package com.example.feng.drawerlayouttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private ListView mMenu;
    private String[] mMenuItems = {
                    "List Item 1",
                    "List Item 2",
                    "List Item 3",
                    "List Item 4"};
    private ArrayAdapter mAdapter;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        mToolbar.setTitle("Toolbar");
        mToolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mAdapter = new ArrayAdapter(this, android.R.layout
                .simple_list_item_1, mMenuItems);
        mMenu.setAdapter(mAdapter);
        mImageView.setImageDrawable(getDrawable(R.mipmap.ic_launcher));
    }

    private void findViews() {
        mImageView = (ImageView) findViewById(R.id.iv_main);
        mToolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.custom_drawer_layout);
        mMenu = (ListView) findViewById(R.id.drawer_menu);
    }
}
