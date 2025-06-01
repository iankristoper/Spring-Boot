



package model;

/**
 *
 * @author noob 
 */



public class Student {
    
    private String id;  //random id (UUID or similar);
    private String name;
    private String gender;      
    
    
    public Student() {
        
    }
    
    public Student(String id, String name, String gender) {
        this.id = id; 
        this.name = name;
        this.gender = gender;
    }
    
    //getters and setters 
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public String getGender() {
        return gender;
    }
}























