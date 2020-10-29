package com.runcode.baro.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.runcode.baro.R;

public class AddCourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
    }

    public void addCourse(View view) {
        startActivity(new Intent(this,CourseLessonsActivity.class));
    }
}