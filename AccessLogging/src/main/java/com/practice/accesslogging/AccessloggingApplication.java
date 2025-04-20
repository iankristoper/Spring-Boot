package com.practice.accesslogging;



//for spring boot 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for aop
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//for annotation
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//for bean factory
import org.springframework.context.ApplicationContext;

//for aop 
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//for time 
import java.time.LocalDateTime;





@SpringBootApplication
public class AccessloggingApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AccessloggingApplication.class, args);
        
        UserService userService = context.getBean(UserService.class);
        
        //simulating user id 
        AuditContext.setCurrentUser("user123");
        userService.getProfile();
        
        AuditContext.setCurrentUser("Admin123");
        userService.updateProfile("Ian");
        
        userService.getProfile();
        
        userService.getProfile();
    }
}

//user context holder 
class AuditContext {
    private static String currentUser;
    
    public static String getCurrentUser() {
        return currentUser;
    }
    
    public static void setCurrentUser(String user) {
        currentUser = user;
    }
}

//service for methods access 
@Service
class UserService {
    public void getProfile() {
        System.out.println("Fetching user Profile...");
    }
    
    public void updateProfile(String name) {
        System.out.println("Updating profile to: " + name);
    }
}

//aop for logging - method peeking 
@Aspect 
@Component 
class AuditLoggerAspect {
    
    @Before("execution(* com.practice.accesslogging.UserService.*(..))")
    public void logAccess(JoinPoint joinPoint) {
        String user = AuditContext.getCurrentUser();
        String methodName = joinPoint.getSignature().getName();
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("\n \n");
        System.out.println("🔍 AUDIT LOG:");
        System.out.println("👤 User: " + user);
        System.out.println("📍 Accessed Method: " + methodName);
        System.out.println("⏰ Time: " + now);
        System.out.println("---------------------------------");
    }
}