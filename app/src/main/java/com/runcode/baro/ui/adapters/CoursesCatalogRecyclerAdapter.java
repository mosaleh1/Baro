package com.runcode.baro.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.runcode.baro.R;
import com.runcode.baro.pojo.Course;

import java.util.List;

public class CoursesCatalogRecyclerAdapter extends RecyclerView.Adapter<CoursesCatalogRecyclerAdapter.CoursesViewHolder> {

    private List<Course> items;

    public CoursesCatalogRecyclerAdapter(List<Course> items) {
        this.items = items;
    }

    @Override
    public CoursesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_item_catalog, parent, false);
        return new CoursesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CoursesViewHolder holder, int position) {
        Course item = items.get(position);
        //TODO Fill in your logic for binding the view.
        holder.courseTitle.setText(item.getCourseTitle());
        holder.courseDescription.setText(item.getCourseDescription());
        holder.continueButton.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }


    public static class CoursesViewHolder extends RecyclerView.ViewHolder {
        TextView courseTitle , courseDescription ;
        Button continueButton ;
        public CoursesViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.courseTitleHomeExplore);
            courseDescription = itemView.findViewById(R.id.courseDescriptionHomeExplore);
            continueButton = itemView.findViewById(R.id.button_Enroll_me);
        }
    }
}