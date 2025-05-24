package org.practice.jdbc_test1;




import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//this class will talk to database 



@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbc;
    
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    //CLI CRUD
    
    //method to talk to database - insert data
    //CREATE 
    public void insertUser(User user) {
        String sql = "INSERT INTO users(id, name, email) VALUES(?,?,?)";
        jdbc.update(sql, user.getId(), user.getName(), user.getEmail());
        System.out.println("Data throws in to database");   
    }
    
    //find one user using id
    //READ
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }
    
    //find all user
    //READ
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    
    //change user data
    //UPDATE
    public void updateUser(User user) {
        String sql = "UPDATE users SET name=?, email=? WHERE id=?";
        int result = jdbc.update(sql, user.getName(), user.getEmail(), user.getId());
        
        if(result > 0) {
            System.out.println("Records udpated.");
        } else {
            System.out.println("No user found to udpate");
        }
    }
    
    //delete user by id
    //DELETE
    public void deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id=?";
        int result = jdbc.update(sql,id);
        
        if(result > 0) {
            System.out.println("User has been deleted in the database");
        } else {
            System.out.println("No user has been deleted");
        }
    }
    
    
    
}
