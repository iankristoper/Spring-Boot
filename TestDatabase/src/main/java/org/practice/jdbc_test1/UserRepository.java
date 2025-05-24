package org.practice.jdbc_test1;




import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


//this class will talk to database 



@Repository
public class UserRepository {
    
    private final JdbcTemplate jdbc;
    
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    //method to talk to database - insert data
    public void insertUser(User user) {
        String sql = "INSERT INTO users(id, name, email) VALUES(?,?,?)";
        jdbc.update(sql, user.getId(), user.getName(), user.getEmail());
        System.out.println("Data throws in to database");
    }
}
