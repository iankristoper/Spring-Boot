package dev.practice.webjdbc;


import org.springframework.web.bind.annotation.*;
import java.util.List;



//this is the interaction in WEB API and the REPOSITORY unto the DATABASE
@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserRepository repo;
    
    public UserController(UserRepository repo) { //->we inject user repository for this class to interact with it
        this.repo = repo;
    }
    
    @PostMapping
    public String createUser(@RequestBody User user) {
        repo.createUser(user);
        return "User Inserted";
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return repo.readUser(id);
    }
    
    @GetMapping 
    public List<User> getAllUser() {
        return repo.readAllUser();
    }
    
    @PutMapping
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        repo.updateUser(user);
        return "User updated";
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        repo.deleteUser(id);
        return "User deleted";
    }
}
