package com.runcode.baro.ui.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.runcode.baro.R;
import com.runcode.baro.ui.adapters.PagerAdapter;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    TabLayout tabLayout;
    TextView tvTitle ;
    private FirebaseAuth mAuth;
    private static final String TAG = "MainActivity";
    private FirebaseUser mCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();
        if (mCurrentUser == null)
        {
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
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

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void clickListeners() {

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_add_course:
                startActivity(new Intent(this,AddCourseActivity.class));
                break;
            case R.id.action_my_courses:
                break;
            case R.id.action_sign_out :
                mAuth.signOut();
                startActivity(new Intent(this,LoginActivity.class));
                break;
        }
        return true ;
    }
}