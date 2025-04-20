package com.practice.banklogging;



//for spring boot initialization
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for bean factory
import org.springframework.context.ApplicationContext;

//for annoatations
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//for aop
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;









@SpringBootApplication
public class BankloggingApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BankloggingApplication.class, args);
        
        BankService service = context.getBean(BankService.class);
        service.deposit(100000);
        service.withdraw(500);
        service.transfer("James", "Sarah", 300);
    }
}




//service for banking operations 
@Service
class BankService {
    public void deposit(double amount) {
        System.out.println("Depositing: " + amount);
    }
    
    public void withdraw(double amount) {
        System.out.println("Withdrawing: " + amount);
    }
    
    public void transfer(String from, String to, double amount) {
        System.out.println("Transferring " + amount + " from " + from + " to " + to);
    }
}



//aspect for logging method calls 
@Aspect 
@Component
class BankingLoggerAspect {
    
    @Around("execution(* com.practice.banklogging.BankService.*(..))") //this is pointcut and advice
    public Object logTransaction(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("\n\n");
        String method = pjp.getSignature().getName();
        System.out.println("Starting " + method + " method...");
        
        Object result = pjp.proceed();
        System.out.println("Finished " + method + " method.");
        
        return result;
    }
    
    @After("execution(* com.practice.banklogging.BankService.*(..))") //this is pointcut and advice
    public void confirmTransaction() {
        System.out.println("Transaction logged successfully");
    }
}











