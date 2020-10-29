package com.runcode.baro.ui.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.runcode.baro.R;

public class LessonInfoActivity extends AppCompatActivity {
    public static final String TITLE_EXTRAS = "com.runcode.baro.ui.Activites.Title";
    public static final String LESSON_EXTRAS = "com.runcode.baro.ui.Activites.Lesson";
    TextView title , lesson ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_info);
        title = findViewById(R.id.title_lesson);
        lesson = findViewById(R.id.lesson_des);

        if (getIntent() != null)
        {
            Intent intent = getIntent();
            String title = intent.getExtras().getString(TITLE_EXTRAS);
            String lesson = intent.getExtras().getString(LESSON_EXTRAS);
            this.title.setText(title);
            this.lesson.setText(lesson);
        }
    }
}