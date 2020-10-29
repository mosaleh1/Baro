package com.runcode.baro.pojo;

public class Lesson {
    private String title ;
    String lesson ;

    public Lesson(String title,String lesson)
    {
        this.title = title;
        this.lesson = lesson  ;
    }
    public Lesson(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }
}
