package test.jdbc.practice;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbc;
    
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    public void insertUser(User user) {
        String sql = "INSERT INTO users (id, name) VALUES (?,?)";
        
        jdbc.update(sql, user.getID(), user.getName());
        System.out.println("User inserted to the database");
    }
}
