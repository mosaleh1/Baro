package com.runcode.baro.pojo;

import java.util.List;

public class User {

   private String uId ;
   private String userName ;
   private List<String> EnrolledCourses;
   private String userEmail ;

   public User(){}

    public User(String uId, String userName, List<String> enrolledCourses, String userEmail) {
        this.uId = uId;
        this.userName = userName;
        EnrolledCourses = enrolledCourses;
        this.userEmail = userEmail;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getEnrolledCourses() {
        return EnrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        EnrolledCourses = enrolledCourses;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
