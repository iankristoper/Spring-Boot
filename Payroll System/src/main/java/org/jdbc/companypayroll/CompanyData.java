package org.jdbc.companypayroll;





public class CompanyData {
    
    private int id;
    private String name;
    private String position;
    private int salary;
    
    //null constructor
    public CompanyData() {
            
    }
    
    //constructor for data initialization
    public CompanyData(int id, String name, String position, int salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
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
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getSalary() {
        return salary;
    }
} 
