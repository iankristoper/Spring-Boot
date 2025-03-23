package com.spring.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import com.spring.projects.Engine;


@Component 
public class Car {
    private final Engine engine;
    
    //constructor based dependency injection
    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
    
    public void showDetails() {
        System.out.println("Car is running with " + engine.getType());
    }
    
    @PostConstruct
    public void init() {
        System.out.println("Car bean is initialized");
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Car bean is about to destroy");
    }
    
    
}
