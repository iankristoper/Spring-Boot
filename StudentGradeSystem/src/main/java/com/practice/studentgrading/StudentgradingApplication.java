package com.practice.studentgrading;



//for initializing spring boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//for bean factory
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

//for annotations
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//for aop
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;




//System where students are graded based on subjects and scores. Use AOP to validate inputs (e.g., score range) and log every operation.





@SpringBootApplication
public class StudentgradingApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StudentgradingApplication.class, args);
        
        StudentGrader records = context.getBean(StudentGrader.class);
        records.gradeStudent("Ian", "Math", 100);
        records.gradeStudent("Rhina", "Major", 100);
        
        try {
            records.gradeStudent("Bill", "Science", 101);
        } catch (Exception e) {
            System.out.println("\nCaught in main: " + e.getMessage());
        }
        
        records.gradeStudent("James", "Major", 100);

    }
}


//core service 
@Service
class StudentGrader {
    public void gradeStudent(String student, String subject, int score) {
        System.out.println("\n\n");
        System.out.println("Student Records");
        System.out.println("Name: " + student);
        System.out.println("Subject: " + subject);
        System.out.println("Score: " + score);
    }
}

//aop for validation and logging 
@Aspect
@Component
class GradingAspect {
    
    //validate score before execution 
    @Before("execution(* com.practice.studentgrading.StudentGrader.gradeStudent(..)) && args(student, subject, score)")
    public void validateScore(String student, String subject, int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Invalid score for " + student + ": " + score);
        }
    }
    
    //log if exception occurs (invalid score)
    @AfterThrowing(pointcut = "execution(* com.practice.studentgrading.StudentGrader.gradeStudent(..))", throwing = "ex")
    public void logInvalidGrade(Exception ex) {
        System.out.println("Error from aop: " + ex.getMessage());
    }
    
    //log after successful grading 
    @After("execution(* com.practice.studentgrading.StudentGrader.gradeStudent(..)) && args(student, subject, score)")
    public void logGrading(String student, String subject, int score) {
        System.out.println("Logged successfully");
        System.out.println("Name: " + student);
    }
}