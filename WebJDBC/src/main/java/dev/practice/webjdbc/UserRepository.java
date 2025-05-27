package dev.practice.webjdbc;


import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  //for database row to java objects vice versa
import org.springframework.jdbc.core.JdbcTemplate;  //for core functions
import org.springframework.stereotype.Repository;  //tells the spring this is DAO


//this class needs the jdbc dependency so we'll put automatic injection on this which means spring will handles this
@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbc;
    
    public UserRepository(JdbcTemplate jdbc) {  //spring will inject the jdbc template
        this.jdbc = jdbc;
    }
    
    //Create 
    public void createUser(User user) {
        String sql = "INSERT INTO users(id, name, email) VALUES(?,?,?)";
        jdbc.update(sql, user.getId(), user.getName(), user.getEmail());
        System.out.println("Data inserted successfully");
        System.out.println("");
    }
    
    //Read - by ID
    public User readUser(int id) {
        String sql = "SELECT * FROM users WHERE id=?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }
    
    //Read - by ALL
    public List<User> readAllUser() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    
    //Update 
    public void updateUser(User user) {
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";
        int result = jdbc.update(sql, user.getName(), user.getEmail(), user.getId());
        
        if(result > 0) {
            System.out.println("Data updated successfully");
        } else {
            System.out.println("No ID match...");
        }
    }
    
    //Delete 
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        int result = jdbc.update(sql,id);
        
        if(result > 0) {
            System.out.println("User deleted successfully");
        } else {
            System.out.println("No ID match...");
        }
    }
}
