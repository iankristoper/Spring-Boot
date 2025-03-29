package com.spring.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;




@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  // ✅ Exclude database auto-config
@RestController
public class ProjectsApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(ProjectsApplication.class, args);


    }
        
       
}

//Engine Class 
class Engine {            
    private String type = "V8 Engine";

    public String getType() {
        return type;
    }
}
        
//Car Class (Depends on Engine)
class Car {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void showDetails() {
        System.out.println("Car is using engine " + engine.getType());
    }

    @PostConstruct
    public void init() {
        System.out.println("Car bean is initialized!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Car bean is about to be destroyed!");
    }
}


//Person class 
class Person {
    private String name = "Ian";

    public String getName() {
        return name;
    }
}