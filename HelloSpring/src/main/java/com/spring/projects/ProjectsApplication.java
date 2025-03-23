package com.spring.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;





@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  // ✅ Exclude database auto-config
@RestController
@RequestMapping("/test")
public class ProjectsApplication {

        public static void main(String[] args) {
            
            //SpringApplication.run(ProjectsApplication.class, args);
            ApplicationContext context = SpringApplication.run(ProjectsApplication.class, args);
                
            // Fetching Singleton Bean (Car)
            Car car = context.getBean(Car.class);
            car.showDetails();

            // Fetching Prototype Beans (Person)
            Person person1 = context.getBean(Person.class);
            Person person2 = context.getBean(Person.class);

            System.out.println("Person 1: " + person1.getName());
            System.out.println("Person 2: " + person2.getName());

            // Checking prototype scope (person1 & person2 should be different instances)
            System.out.println("Are person1 and person2 same? " + (person1 == person2));
        }

        @Bean
        public CommandLineRunner commandLineRunner() {
            return args -> {
                System.out.println("Spring Boot Application Started!");
            };
        }
         
        @GetMapping("/hello")
        public String testHello() {
                return "Hello pakshit";
        }
}
