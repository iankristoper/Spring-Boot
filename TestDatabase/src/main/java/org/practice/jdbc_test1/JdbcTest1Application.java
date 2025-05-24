package org.practice.jdbc_test1;




import java.util.List;
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
    CommandLineRunner run(UserCLI cli) {
        return args -> {
            cli.start();
        };
    }
}             
            
