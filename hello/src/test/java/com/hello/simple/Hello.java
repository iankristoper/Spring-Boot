package com.hello.simple;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



@SpringBootApplication
public class Hello {
    public static void main(String[] args) {
        System.out.println("Starting spring boot application...");
        
        // Using ApplicationContext to manage beans
        ApplicationContext context = SpringApplication.run(Hello.class, args);
        System.out.println("Application context loaded......");
        
        // Fetching a bean from the context container
        MyBean sampleBean = context.getBean(MyBean.class);
    }
    
    @Component
    public static class MyBean {
        public MyBean() {
            System.out.println("MyBean has been initialized...");
        }
    }
    
    
    
}
