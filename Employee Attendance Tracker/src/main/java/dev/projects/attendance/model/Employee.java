
package dev.projects.attendance.model;

/**
 *
 * @author Ian Tagano
 */



public class Employee {
    
    private int id;
    private String name;
    
    
    public Employee() {
        
    }
    
    //constructor based
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    
    //getters and setters
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
