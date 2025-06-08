

package dao;



/**
 *
 * @author noob
 */


import model.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

   

@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbc;   
    
    public UserRepository(JdbcTemplate jdbc) { //contructor based dependency injection - no need autowired it is automatic
        this.jdbc = jdbc;
    }
    
    
    //create -> insert data in the database
    public int createUser(User user) {
        String sql = "INSERT INTO employee(name) VALUES=?";
        return jdbc.update(sql, user.getName());
    }
    
    
    //read -> read data on the database - by id only
    public User getUserId(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }
    
    
    //read -> raad data from the database - all data
    public List<User> getAllUser() {
        String sql = "SELECT * FROM employee";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
    
    
    //delete -> delete data from the database
    public int deleteUser(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        return jdbc.update(sql, id);
    } 
}
