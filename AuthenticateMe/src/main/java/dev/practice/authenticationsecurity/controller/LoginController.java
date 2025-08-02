
package dev.practice.authenticationsecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;







@RestController
@RequestMapping("/success")
public class LoginController {
    
    
    @GetMapping("/index")
    public String welcomeMessage() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        
        return "Hello, " + username + ". Welcome to my simple test program";
    }
}
