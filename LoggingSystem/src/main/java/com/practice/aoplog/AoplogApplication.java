package com.practice.aoplog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@SpringBootApplication
public class AoplogApplication {
    public static void main(String[] args) {
        System.out.println("Spring boot is running...vrommmmmm!");
        ApplicationContext context = SpringApplication.run(AoplogApplication.class, args);   
    }
}

//service class or the business logic
@Service 
class TaskService {
    public void performTask() {
        System.out.println("Task is being loaded");
    }
    
    public void completeTask() {
        System.out.println("Task has been completed");
    }
}

//logging aspect 
@Aspect
@Component
class LoggingAspect {
    @Pointcut("execution(* com.practice.aoplog.*(..))")
    private void taskServiceMethods() {}
    
    @Before("taskServiceMethods()")
    public void beforeAdvice() {
        System.out.println("Before -> method execution started");
    }
    
    @After("taskServiceMethods()")
    public void afterAdvice() {
        System.out.println("After -> method execution completed");
    }
    
    @Around("taskServiceMethods()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); 

        long endTime = System.currentTimeMillis();
        System.out.println("⏳ Execution Time: " + (endTime - startTime) + "ms");

        return result;
    }
}
