package com.testing.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;





@SpringBootApplication
@EnableAspectJAutoProxy // Enables AspectJ-based AOP in Spring
public class AopApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopApplication.class, args);
        
        // Retrieve the service bean and call its method
        MyService myService = context.getBean(MyService.class);
        myService.doSomething();
        myService.doSomething();
    }
}

//Business logic is in here (service layer)
@Service
class MyService {
    public void doSomething() {
        System.out.println("This is coming from the service annotation");
    }
}

//AOP for logging 
@Aspect
@Component
class LoggingAspect {
    //log before method execution 
    @Before("execution(* MyService.*(..))")
    public void logBeforeMethod() {
        System.out.println("AOP Logging: Before main method");
    }
  
    //Log after method execution
    @After("execution(* MyService.*(..))")
    public void logAfterMethod() {
        System.out.println("AOP Logging: After main method");
    }
}
