package com.runcode.baro.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.runcode.baro.R;
import com.runcode.baro.pojo.Lesson;
import com.runcode.baro.ui.Activities.LessonInfoActivity;

import java.util.List;

import static com.runcode.baro.ui.Activities.LessonInfoActivity.LESSON_EXTRAS;
import static com.runcode.baro.ui.Activities.LessonInfoActivity.TITLE_EXTRAS;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonsViewHolder> {


    public void setItems(List<Lesson> items) {
        this.items = items;
    }

    private List<Lesson> items;
    Context context;

    public LessonsAdapter(List<Lesson> items, Context context) {
        this.items = items;
        this.context = context;

    }

    @Override
    public LessonsViewHolder onCreateViewHolder(ViewGroup parent,
                                                int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lesson_item, parent, false);
        return new LessonsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LessonsViewHolder holder, int position) {
        Lesson item = items.get(position);
        //TODO Fill in your logic for binding the view.
        holder.title.setText(item.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LessonInfoActivity.class);
                intent.putExtra(TITLE_EXTRAS,item.getTitle());
                intent.putExtra(LESSON_EXTRAS,item.getLesson());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class LessonsViewHolder extends RecyclerView.ViewHolder {
        TextView title ;
        public LessonsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lesson_text_name);
        }
    }
}