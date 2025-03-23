package com.spring.projects;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype") // Prototype scope: New instance every time
public class Person {
    
    private String name = "Ian";
    
    public String getName() {
        return name;
    }
    
}
