package test.jdbc.practice;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;




@SpringBootApplication
public class PracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }
    
    
    @Bean
    CommandLineRunner run(UserRepository repo) {
        return args -> {
            User user = new User(1, "James");
            repo.insertUser(user);
        };
    }

}
