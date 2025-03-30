package com.system.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
public class EmployeeApplication {

    public static void main(String[] args) {
        
        System.out.println("Spring boot is loading...123");
        
        //initiate the application context to manage the beans 
        ApplicationContext context = SpringApplication.run(EmployeeApplication.class, args);
        
        Employee firstEmployee = context.getBean(Employee.class);
        firstEmployee.displayDetails();
    }
    
    @Bean 
    public CommandLineRunner commandLineRunner() {
        return args -> System.out.println("Application Running...this is from the command line runner");
    }
}

//
@Component
class Employee {
    private final Role role;
    private final Department department;
    
    //contrcutor for dependency injection 
    public Employee(Role role, Department department) {
        this.role = role;
        this.department = department;
        System.out.println("Employee bean has been created and the dependency injection has been triggered");
        System.out.println("This is coming from the Employee class contructor");
    }
    
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("   - Role: " + role.getRoleName());
        System.out.println("   - Department: " + department.getDepartmentName());
    }
    
    @PostConstruct
    public void init() {
        System.out.println("Employee post construct has been executed");
    }
}

//
@Component
class Role {
    public Role() {
        System.out.println("Role bean has been created");
    }
    
    public String getRoleName() {
        return "Backend Engineer";
    }
}

//
@Component
class Department {
    public Department() {
        System.out.println("Department bean has been created");
    }
    
    public String getDepartmentName() {
        return "IT Department";
    }
}


