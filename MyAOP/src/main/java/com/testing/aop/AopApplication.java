package com.testing.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Service;
import org.
import org.springframework.stereotype.Component;





@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}

//
@Service
class MyService {
    public void doSomething() {
        System.out.println("This is coming from the service annotation");
    }
}
