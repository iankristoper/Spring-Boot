package com.practice.tryjdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




//this class is for the database connection and passing the data to the mysql


@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate jTemplate;
    
    public void saveUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        jTemplate.update(sql, user.getName(), user.getEmail());
        System.out.println("User saved to database!");
    }
}
