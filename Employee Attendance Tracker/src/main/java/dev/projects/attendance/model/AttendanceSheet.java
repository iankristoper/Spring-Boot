
package dev.projects.attendance.model;

/**
 *
 * @author Ian Tagano
 */



import java.time.LocalDate;



public class AttendanceSheet {
    
    private int id;
    private int employeeId;
    private LocalDate date;
    private String status;
    
    
    public AttendanceSheet() {
        
    }
    
    //constructor based
    public AttendanceSheet(int id, int employeeId, LocalDate date, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }
    
    
    //getters and setters
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
 }
