package com.example.fms.models;

public class StudentModel {
    private String Uid;
    private String Email;

    public StudentModel(String uid, String email) {
        Uid = uid;
        Email = email;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
