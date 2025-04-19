package com.practice.inputvalidation;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.context.ApplicationContext;



//A service method that takes user input (like a name or email).
//An aspect that checks if the input is valid before allowing the method to execute.






@SpringBootApplication
public class InputvalidationApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InputvalidationApplication.class, args);
        
        UserService service = context.getBean(UserService.class);
        
        // Test 1: Valid input
        service.registerUser("James", "james@example.com");

        // Test 2: Invalid input (empty name)
        service.registerUser("", "no-name@example.com");
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
    @Before("execution(* *..UserService.registerUser(..))")
    public void validateInputs(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        
        String name = (String) args[0];
        String email = (String) args[1];
        
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ [Validation Failed] Name cannot be empty!");
            throw new IllegalArgumentException("Name is required.");
        }

        if (email == null || !email.contains("@")) {
            System.out.println("❌ [Validation Failed] Email must be valid!");
            throw new IllegalArgumentException("Valid email is required.");
        }

        System.out.println("✅ [Validation Passed] Name and email are valid.");
    }
}