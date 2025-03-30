package com.system.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;










@SpringBootApplication
public class RegistrationApplication {
    public static void main(String[] args) {
        
        System.out.println("Spring is on fire again...waaaaarghhhhhh!!");
        
        //initialize the application context to load the class to the container 
        ApplicationContext context = SpringApplication.run(RegistrationApplication.class, args);
        
        UserService user = context.getBean(UserService.class);
        user.registerUser("Ian", "ian@nani.email");
        user.registerUser("nani", "nani@nani.email");
        
        // Display registered users
        //user.displayUsers();
    }
}

//

class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        System.out.println("User has been created -> User.class");
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
}

//
@Component
class UserService {
    private final List<User> users = new ArrayList<>();
    
    public UserService() {
        System.out.println("User service has been created -> UserService.class");
    }
    
    public void registerUser(String name, String email) {
        User user = new User(name, email);
        users.add(user);
        System.out.println("New User has been Registered");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("");
    }
    
    public void displayUsers() {
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
        }
    }
    
    @PostConstruct
    public void init() {
        System.out.println("User Registration System Initialized! ->post construct");
    }
}