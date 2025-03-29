package com.justonce.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class IntroApplication {
    public static void main(String[] args) {
        System.out.println("Starting spring boot application...123");

        //create the application context container -> will handle beans and load all the beans 
        ApplicationContext context = SpringApplication.run(IntroApplication.class, args);
        System.out.println("Application context loaded......this was loaded after all the class under context hs been loaded resulting to become a spring bean");
        
        //retrieving the beans from the context container
        //Car car = context.getBean(Car.class);
        //car.start();
    }
    
    @Component
    class Car {
        private final Engine engine;
        
        //constructor-based dependency injection
        public Car(Engine engine) {
            this.engine = engine;
            System.out.println("Car has been created...by the context container");
            System.out.println("The constructor has been initialized with dependency injection -> Engine has been injected into the Car class");
        }
        
        public void start() {
            System.out.println("Car is starting...vroom vrooom! -> coming from the start function");
            engine.run();
        }
    }
  
    @Component 
    class Engine {
        public Engine() {
            System.out.println("Engine been created...by the context container");
        }
        
        public void run() {
            System.out.println("Engine is running...chrrr -> from the run function");
        }
    }
    
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("Application Running...this is from the commanline runner");
    }
}
