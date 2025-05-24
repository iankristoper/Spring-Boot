package org.practice.jdbc_test1;




import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.context.annotation.Bean;
import java.util.Scanner;



@SpringBootApplication
public class JdbcTest1Application {
    
    public static void main(String[] args) {
        SpringApplication.run(JdbcTest1Application.class, args);
    }
    
    //after spring being initiated this method will run and insert the data
    @Bean //spring will handle this as bean(object)
    CommandLineRunner run(UserRepository repo) {
        return args -> {
            
            User user = new User();
            Scanner scanner = new Scanner(System.in);
            boolean isLineRunning = true;
            
            while(isLineRunning) {
                System.out.println("");
                System.out.println("BASIC CLI PROGRAM (CRUD VERSION)");
                System.out.println("[1] Create Data");
                System.out.println("[2] Read Data by ID");
                System.out.println("[3] Read Data by All");
                System.out.println("[4] Update Data by ID");
                System.out.println("[5] Delete Data by ID");
                System.out.println("[6] Exit Spring Boot");
                
                System.out.print("Input your selection: ");
                int input = scanner.nextInt();
                scanner.nextLine();
                                        
                switch(input) {
                    //CREATE
                    case 1:
                        System.out.println("");
                        System.out.print("Enter your ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter your email address: ");
                        String email = scanner.nextLine();

                        user.setId(id);
                        user.setName(name);
                        user.setEmail(email);
                        
                        System.out.println("");
                        System.out.println("Data to insert");
                        System.out.println("ID: " + user.getId());
                        System.out.println("Name: " + user.getName());
                        System.out.println("Email: " + user.getEmail());
                        repo.insertUser(user); 
                        break;
                    
                    //READ
                    case 2:
                        System.out.println("");
                        System.out.print("Enter ID you wanted to check: ");
                        int idInfo = scanner.nextInt();
                        scanner.nextLine();          
                        
                        user = repo.getUserById(idInfo);
                        
                        System.out.println("Extracted data...");
                        System.out.println("Name: " + user.getName());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("ID: " + user.getId());
                        System.out.println("No more data...");
                        System.out.println("");
                        break;
                    
                    //READ
                    case 3:
                        System.out.println("");
                        System.out.println("Extracted all data...");
                        System.out.println("");
                        
                        List<User> listUser = repo.getAllUser();
                        
                        for(User copy : listUser) {
                            System.out.println("Id: " + copy.getId());
                            System.out.println("Name: " + copy.getName());
                            System.out.println("Email: " + copy.getEmail());
                            System.out.println("");
                        }
                                           
                        System.out.println("No more data...");
                        
                        break;
                        
                    //UPDATE
                    case 4:
                        System.out.println("");
                        System.out.println("Update details...");
                        System.out.println("");
                        
                        System.out.print("Enter ID to update: ");
                        int idUpdate = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("New name: ");
                        String newName = scanner.nextLine();
                        
                        System.out.print("New email: ");
                        String newEmail = scanner.nextLine();
                        
                        User updateUser = new User(idUpdate, newName, newEmail);
                        
                        repo.updateUser(updateUser);
                        
                        System.out.println("");
                        System.out.println("User has been updated ");
                        
                        break;
                        
                    case 5:
                        System.out.println("");
                        System.out.print("Enter ID to delete user: ");
                        int idDelete = scanner.nextInt();
                        
                        repo.deleteUser(idDelete);
                        System.out.println("");
                        
                        break;
                        
                    case 6:
                        isLineRunning = false;
                        System.out.println("Thanks for using......");
                        System.out.println("Program abort.");
                        return;
                        
                    default:
                        System.out.println("Invalid choice, try again...");
                        break;
                }
                        
            }      
        };
    }
}             
            
