package com.world.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // 👈 This makes the class a REST controller
@RequestMapping("/myapi") // 👈 Base path for the API
public class DemoApplication {  

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Spring Boot is running!");
    }

    // ✅ Add this API endpoint method
    @GetMapping("/test")
    public String testEndpoint() {
        return "Spring Boot is working!";
    }
}
