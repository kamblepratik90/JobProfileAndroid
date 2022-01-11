package com.example.jobprofile;
import android.util.EventLogTags;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponce {
//    {
//        "user": {
//              "name": "neha2"
//        },
//        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2MWRkMzU1OGQ0NWE0MmY4MjliMWJjOWUiLCJuYW1lIjoibmVoYTIiLCJpYXQiOjE2NDE4ODcwNjQsImV4cCI6MTY0NDQ3OTA2NH0.hgOAq5uVd2zJooBD5-wjDRcL-1MdM1lwUievQse4DCE",
//        "message": "neha2 registered successfully! Please check your mail"
//    }
    private User user;
    private String token;
    private String message;

    public LoginResponce(User user, String token,String message) {
        this.user = user;
        this.token = token;
        this.message=message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class User
    {
        String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

