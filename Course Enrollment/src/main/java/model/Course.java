
package model;

/**
 *
 * @author noob
 */


public class Course {
    
    private String id;
    private String title;
    
    public Course() {
        
    }
    
    public Course(String id, String title) {
        this.id = id;
        this.title = title;
    }
    
    //getters and setters 
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    } 
}
