package com.spring.projects;

import org.springframework.stereotype.Component;


@Component 
public class Engine {
    
    private String type = "V8 Engine";
    
    public String getType() {
        return type;
    }
}
