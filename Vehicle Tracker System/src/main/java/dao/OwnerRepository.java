package dao;

/**
 *
 * @author noob
 */


import model.Owner;

import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;



//lets inject the NamedParameterJdbcTemplate on this class


@Repository 
public class OwnerRepository {
    
    private final JdbcTemplate jdbc;
    
    public OwnerRepository(JdbcTemplate jdbc) {   //contructor injection - no need autowired
        this.jdbc = jdbc;
    }
    
    
    //create
    public int createOwner(Owner owner) {
        String sql = "INSERT INTO owner(name, email) VALUES(?,?)";
        return jdbc.update(sql, owner.getName(), owner.getEmail());
    }
    
    
    //read all
    public List<Owner> readAll() {
        String sql = "SELECT * FROM owner";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Owner.class));
    }
    
    
    //read by id
    public Owner readById() {
        String sql = "SELECT FROM owner WHERE id=?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Owner.class));
    }
    
    
    //no update method for this function
    
    
    //delete
    public String deleteOwner(int ownerId) {
        String sql = "DELETE FROM owner WHERE id=?";
        int result = jdbc.update(sql, ownerId);
        
        if(result > 0) {
            return "Owner deleted successfully";
        } else {
            return "ID does not match any Owner data";
        }
    }
    
}
