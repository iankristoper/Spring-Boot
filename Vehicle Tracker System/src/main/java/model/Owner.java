
package model;

/**
 *
 * @author noob
 */


public class Owner {
    
    private int ownerId;
    private String name;
    private String email;
    
    //contructor
    public Owner() {
        
    }
    
    public Owner(int ownerId, String name, String email) {
        this.ownerId = ownerId;
        this.name = name;
        this.email = email;
    }
    
    //getters and setters 
    public void setId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    public int getId() {
        return ownerId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
}

