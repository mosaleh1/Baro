package com.runcode.baro.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.runcode.baro.R;
import com.runcode.baro.pojo.Course;
import com.runcode.baro.pojo.Lesson;
import com.runcode.baro.ui.adapters.CoursesRecyclerAdapter;
import com.runcode.baro.ui.adapters.LessonsAdapter;

import java.util.ArrayList;
import java.util.List;

public class CourseLessonsActivity extends AppCompatActivity {
    LessonsAdapter mAdapter ;
    RecyclerView listLessons;
    LinearLayoutManager mLayoutManager ;
    private List<Lesson> mItems;
    int counter = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_lessons);
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        listLessons = findViewById(R.id.lessons_list);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setStackFromEnd(true);
        mItems = new ArrayList<>();
        mItems.add(new Lesson("lesson 1",getString(R.string.long_text_course_description)));
        mItems.add(new Lesson("lesson 2",getString(R.string.long_text_course_description)));
        mItems.add(new Lesson("lesson 3",getString(R.string.long_text_course_description)));
        mItems.add(new Lesson("lesson 4",getString(R.string.long_text_course_description)));
        mAdapter = new LessonsAdapter(mItems,this);
        listLessons.setLayoutManager(mLayoutManager);
        listLessons.setAdapter(mAdapter);
    }

    public void add_lesson(View view) {
        startActivity(new Intent(this,AddLessonActivity.class));
        finish();
    }
}