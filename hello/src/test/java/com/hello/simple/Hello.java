package com.hello.simple;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class Hello {
    public static void main(String[] args) {
        System.out.println("Starting spring boot application...");
        
        // Using ApplicationContext to manage beans
        ApplicationContext context = SpringApplication.run(Hello.class, args);
        System.out.println("Application context loaded...");
        
        // Fetching a bean from the context container
        MyBean sampleBean = context.getBean(MyBean.class);
        sampleBean.sayHello();
    }
    
    @Component
    public static class MyBean {
        public MyBean() {
            System.out.println("MyBean has been initialized...");
        }
        
        public void sayHello() {
            System.out.println("Hello from sayHello -> MyBean");
        }
        
        @PostConstruct
        public void init() {
            System.out.println("MyBean PostConstruct has been executed");
        }
    }
    
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("\n🚀 Application Running...");
    }
    
}
