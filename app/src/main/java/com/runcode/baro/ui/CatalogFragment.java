package com.runcode.baro.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.runcode.baro.R;
import com.runcode.baro.ui.adapters.CoursesCatalogRecyclerAdapter;
import com.runcode.baro.pojo.Course;

import java.util.ArrayList;
import java.util.List;


public class CatalogFragment extends Fragment {
    RecyclerView coursesList;
    List<Course> mCourses;
    CoursesCatalogRecyclerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        coursesList = view.findViewById(R.id.Explore_RecyclerView);
        mCourses = new ArrayList<>();
        mAdapter = new CoursesCatalogRecyclerAdapter(mCourses);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(container.getContext());
        coursesList.setLayoutManager(manager);
        coursesList.setAdapter(mAdapter);
        addValues();
        return view;
    }

    private void addValues() {
        mCourses.add(new Course("Math for ML", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Artificial Intelligence", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Algorithms", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Data Structure", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Database (SQL)", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Oracle DB", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("intro to Java", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("intro to JavaScript", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("HTML for beginners", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("OOP in java", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("Object oriented design", getString(R.string.long_text_course_description)));
        mCourses.add(new Course("CSS for kids", getString(R.string.long_text_course_description)));
        mAdapter.notifyDataSetChanged();
    }
}