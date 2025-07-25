
package dev.practice.authenticationsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/user")
public class UserController {
    
    
    @GetMapping("/welcome")
    public String welcomeUser() {
        return "Hello user, welcome aboard!";
    }
}
