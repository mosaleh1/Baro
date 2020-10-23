package com.runcode.baro.pojo;

enum COURSE_LEVEL
{
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}
public class Course
{
    String courseId ;
    String courseTitle ;
    String courseDescription ;
    String publisherName ;
    String publisherId ;
    COURSE_LEVEL courseLevel ;
    public Course (){}

    public Course(String courseTitle, String courseDescription) {
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
    }

    public Course(String courseId, String courseTitle, String courseDescription, String publisherName, String publisherId) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseDescription = courseDescription;
        this.publisherName = publisherName;
        this.publisherId = publisherId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    public COURSE_LEVEL getCourseLevel()
        {
            return courseLevel ;
        }
}
