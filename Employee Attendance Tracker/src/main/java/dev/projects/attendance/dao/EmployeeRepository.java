
package dev.projects.attendance.dao;

/**
 *
 * @author Ian Tagano
 */



import dev.projects.attendance.model.Employee;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;



@Repository
public class EmployeeRepository {
    
    private final JdbcTemplate jdbc;
    
    
    //constructor based injection
    public EmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    //crud operation
    
    //create
    public void createEmployee(Employee employee) { 
        String sql = "INSERT INTO employee (name) VALUES (?)";
        jdbc.update(sql, employee.getName());
    }
    
    
    //read by id
    public Employee readById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), id);
    }
    
    
    //read by all
    public List<Employee> readAll() {
        String sql = "SELECT * FROM employee";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Employee.class));
    }
    
    
    //delete 
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbc.update(sql, id);
    }
}

