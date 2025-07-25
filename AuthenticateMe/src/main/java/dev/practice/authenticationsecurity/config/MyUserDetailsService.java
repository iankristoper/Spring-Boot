
package dev.practice.authenticationsecurity.config;





import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;







@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired 
    private JdbcTemplate jdbc;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                
        
        
        try {
            
            //find the admin in the table 
            String sql = "SELECT * FROM admins WHERE username = ?";
            
            return jdbc.queryForObject(sql, new Object[]{username}, (rs, rowNum) -> {
                String dbUsername = rs.getString("username");
                String dbPassword = rs.getString("password");
                String dbRole = rs.getString("role");
                
                return User.withUsername(dbUsername)
                        .password(dbPassword)
                        .roles(dbRole)
                        .build();
            });
            
            
            
        } catch(EmptyResultDataAccessException e) {
            
            try {
                
                //if no admin, try the users table 
                String sql = "SELECT * FROM users WHERE username = ?";
                
                return jdbc.queryForObject(sql, new Object[] {username}, (rs, rowNum) -> {
                    String dbUsername = rs.getString("username");
                    String dbPassword = rs.getString("password");
                    String dbRole = rs.getString("role");
                    
                    return User.withUsername(dbUsername)
                            .password(dbPassword)
                            .roles(dbRole)
                            .build();
                });         
            } catch(EmptyResultDataAccessException ex) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
        }
        
    }
}
