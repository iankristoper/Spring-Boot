
package dev.practice.authenticationsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/auth")
public class PublicController {
    
    
    @GetMapping("/login")
    public String login() {
        return "This is for login - under construction";
    }
    
}
