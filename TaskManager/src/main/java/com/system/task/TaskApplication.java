package com.system.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;









@SpringBootApplication
public class TaskApplication {
    public static void main(String[] args) {
        
        System.out.println("Spring Boot is running...fireeeeeeeee!!!");
        
        //initiate the java based container this will call all components and initialize them as beans 
        ApplicationContext context = SpringApplication.run(TaskApplication.class, args);
        
        TaskManager task = context.getBean(TaskManager.class);
        task.showTasks();
        task.cleanup();
    }
}

//
@Component 
class TaskManager {
    private final List<String> tasks = new ArrayList<>();  //final to prevent unexpected assign - the object can be still modified
    
    public TaskManager() {
        System.out.println("Task Manager clas has been initialize as beans -> this will become a spring beans");
    }
    
    // Runs after the bean is created → Initializes tasks
    @PostConstruct
    public void init() {
        System.out.println("Initializing tasks...This is coming from post construct");
        tasks.add("Jogging in the morning");
        tasks.add("Eat breakfast");
        tasks.add("Code");
        System.out.println("Task has been initialized...exiting");
    }
    
    public void showTasks() {
        System.out.println("Task List:");
        tasks.forEach(System.out::println);
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("Cleaning up the tasks...");
        tasks.clear();
        System.out.println("System cleared - all tasks removed before shutdown!");
    }
}
