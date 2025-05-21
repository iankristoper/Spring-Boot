
package repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import model.User;


@Repository //tells spring this is data access component
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    
    public UserRepository (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public int save(User user) {
        return jdbcTemplate.update("INSERT INTO users(name, email) VALUES (?,?)",user.getName(), user.getEmail());
    }
    
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", new BeanPropertyRowMapper<>(User.class));
    }
    
    public User findByID(int ID) {
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?",
                new BeanPropertyRowMapper<>(User.class), ID);
    }
    
    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET name = ?, email = ? WHERE id = ?",
                user.getName(), user.getEmail(), user.getID());
    }
    
    public int deleteById(int ID) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", ID);
    }
}
