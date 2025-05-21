package controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import model.User;
import repository.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final UserRepository userRepo;
    
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    @PostMapping
    public String createUser(@RequestBody User user) {
        userRepo.save(user);
        return "User created successfully!";
    }
    
    @GetMapping
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepo.findByID(id);
    }
    
    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        user.setID(id);
        userRepo.update(user);
        return "User updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userRepo.deleteById(id);
        return "User deleted!";
    }
}
