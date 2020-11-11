package com.example.androidproject;

public class Factory {

    public static User makeUser(){
        return new User("din_djarin", "baby_yoda_ftw");
    }

    public static Boolean checkUsername(User u, String username)
    {
        return u.getUsername().equals(username);
    }

    public static Boolean checkPassword(User u, String password)
    {
        return u.getPassword().equals(password);
    }
}
