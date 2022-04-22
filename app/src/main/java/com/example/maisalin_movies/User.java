package com.example.maisalin_movies;

public class User {
    private String email;
    private String password;
    private String userName;
    private String key;
    //private String likes;


    public User() {
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    /*public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }*/

}