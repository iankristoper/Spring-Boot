package test.jdbc.practice;





public class User {
    
    private int id;
    private String name;
    
    //constructors
    public User() {};
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    //getters and setters
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
