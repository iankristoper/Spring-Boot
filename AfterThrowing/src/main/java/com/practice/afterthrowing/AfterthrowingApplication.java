package com.practice.afterthrowing;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for bean factory
import org.springframework.context.ApplicationContext;

//for aop
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

//for annotations
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;






@SpringBootApplication
public class AfterthrowingApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AfterthrowingApplication.class, args);
        
        Calculator calcu = context.getBean(Calculator.class);
        
        try {
            calcu.divide(10, 0);
        } catch (Exception e) {
            System.out.println("Exception handled in main: " + e.getMessage());
        }
    }
}

//for normal methods 
@Service
class Calculator {
    public int divide(int a, int b) {
        return a / b;
    }
}

//this class is for logging using aop 
@Aspect 
@Component 
class ExceptionLoggerAspect {
    
    @AfterThrowing(pointcut = "execution(* com.practice.afterthrowing.Calculator.*(..))", throwing = "ex")
    public void logException(Exception ex) {
        System.out.println("Exception caught by AOP: " + ex);
    }
}