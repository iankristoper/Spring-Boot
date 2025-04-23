package com.practice.tryjdbc;


//for spring initialization
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for bean container
import org.springframework.context.ApplicationContext;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



@SpringBootApplication
public class TryjdbcApplication implements CommandLineRunner {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TryjdbcApplication.class, args);
    }
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) {
        User user = new User("Ian", "james@email.com");
        userRepository.saveUser(user);
    }
}

