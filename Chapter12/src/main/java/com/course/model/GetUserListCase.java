package com.course.model;

public class GetUserListCase {
    private int id;
    private String userName;
    private String age;
    private String sex;
    private String expected;


    public String getExpected() {
        return expected;
    }
    public void setExpected(String expected){
        this.expected=expected;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }
    public void setAge(String age){
        this.age=age;
    }

    public String getSex() {
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
}
