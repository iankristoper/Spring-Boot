package com.practice.inputvalidation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//A service method that takes user input (like a name or email).
//An aspect that checks if the input is valid before allowing the method to execute.


@SpringBootApplication
public class InputvalidationApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InputvalidationApplication.class, args);
    }
}


//business logic is here 
@Service 
class UserService {
    public void registerUser(String name, String email) {
        System.out.println("User registered: " + name + "("+ email +")");
    }
}

@Aspect 
@Component 
class InputValidationAspect {
    @Before("execution(* com.example.UserService.registerUser(..))")
    public void validateInputs(JointPoint joinPoint) throws Throwable {
        
    }
}