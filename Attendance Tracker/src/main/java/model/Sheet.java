
package model;

/**
 *
 * @author noob
 */


import java.time.LocalDate;


public class Sheet {
    
    private int id;
    private int userId;
    private LocalDate dateObj;
    private String status;
    
    public Sheet() {
        
    }
    
    public Sheet(int id, int userId, LocalDate dateObj, String status) {
        this.id = id;
        this.userId = userId;
        this.dateObj = dateObj;
        this.status = status;
    }
    
    
    //getters and setters 
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    
    public void setLocalDate(LocalDate dateObj) {
        this.dateObj = dateObj;
    }
    
    public LocalDate getLocalDate() {
        return dateObj;
    }
    
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
}
