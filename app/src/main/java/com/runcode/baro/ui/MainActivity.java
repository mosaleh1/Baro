package com.runcode.baro.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.runcode.baro.R;
import com.runcode.baro.ui.adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    TextView tvTitle ;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Toolbar toolbar =  findViewById(R.id.main_activity_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        viewPager = findViewById(R.id.pager);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        // It is used to join TabLayout with ViewPager.
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        int[] icons = {
                R.drawable.ic_home,
                R.drawable.ic_compass,
                R.drawable.ic_setting
        };
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(icons[i]);
        }
        clickListeners();
    }

    private void clickListeners() {
        pagerAdapter.setListener(new PagerAdapter.onChangeFragmentListener() {
            @Override
            public void onChange(int position, String title) {
                tvTitle.setText(title);
                Log.d(TAG, "onChange: position is  "+ position +"title is: "+title);
            }
        });
    }

    private void initViews() {
        tabLayout = findViewById(R.id.tab_layout);
        tvTitle = findViewById(R.id.tv_title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
}