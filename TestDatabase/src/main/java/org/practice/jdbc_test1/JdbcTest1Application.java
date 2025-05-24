package org.practice.jdbc_test1;




import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import java.util.Scanner;



@SpringBootApplication
public class JdbcTest1Application {
    
    public static void main(String[] args) {
        SpringApplication.run(JdbcTest1Application.class, args);
    }
    
    //after spring being initiated this method will run and insert the data
    @Bean //spring will handle this as bean(object)
    CommandLineRunner run(UserRepository repo) {
        return args -> {
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Enter your ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter your email address: ");
            String email = scanner.nextLine();
            
            User user = new User(id, name, email);
            
            System.out.println("");
            System.out.println("Data to insert");
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            repo.insertUser(user); 
        };
    }
}
