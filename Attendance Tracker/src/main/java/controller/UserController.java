
package controller;

/**
 *
 * @author noob
 */

import dao.UserRepository;
import model.User;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class UserController {
      
    private final UserRepository userRepo;
    
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
    
    
    //create data -> POST
    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) { //convert JSON to java object and vice versa
        userRepo.createUser(user);
        return ResponseEntity.ok("User added successfully");
        
    }
    
    
    //read data -> GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        User user = userRepo.getUserId(id);
        
        if(user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    //read date -> GET all date
    @GetMapping 
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userRepo.getAllUser();
        return ResponseEntity.ok(user);
    }
    
    
    //delete -> DELETE employee data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userRepo.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }       
}
