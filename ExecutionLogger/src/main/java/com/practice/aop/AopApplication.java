package com.practice.aop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;







@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopApplication.class, args);
        
        MyService service = context.getBean(MyService.class);
        service.doTask();
        System.out.println("This is the between method");
        System.out.println("");
        service.doTask();
    }
}

@Service 
class MyService {
    public void doTask() {
        System.out.println("DOing some important task...this is from the service class");
    }
}

@Aspect
@Component
//aspect class this is where the aop is happening 
class LoggingAspect {
    @Before("execution(* com.practice.aop.MyService.doTask(..))")
    public void logBefore() {
        System.out.println("[Before] doTask() is being called");
    }
    
    @After("execution(* com.practice.aop.MyService.doTask(..))")
    public void logAfter() {
        System.out.println("[After] doTask() has been executed");
    }
    
    @Around("execution(* com.practice.aop.MyService.doTask(..))")
    public void logAround() {
        System.out.println("[Around] THIS WILL RUN BEFORE AND AFTER");
    }
}
