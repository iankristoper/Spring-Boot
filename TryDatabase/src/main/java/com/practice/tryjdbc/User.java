package com.practice.tryjdbc;


//this class file is for the user data 


public class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
