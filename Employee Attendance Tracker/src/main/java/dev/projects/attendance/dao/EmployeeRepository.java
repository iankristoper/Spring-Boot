
package dev.projects.attendance.dao;

/**
 *
 * @author Ian Tagano
 */



import dev.projects.attendance.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class EmployeeRepository {
    
    private final JdbcTemplate jdbc;
    
    
    //constructor based injection
    public EmployeeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    
    //using of rowmapper 
    public class EmployeeRowMapper implements RowMapper<Employee> {
        
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee emp = new Employee();
            emp.setId(rs.getInt("id"));
            emp.setName(rs.getString("name"));
            return emp;
        }
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
        return jdbc.queryForObject(sql, new EmployeeRowMapper(), id);
    }
    
    
    //read by all
    public List<Employee> readAll() {
        String sql = "SELECT * FROM employee";
        return jdbc.query(sql, new EmployeeRowMapper());
    }
    
    
    //delete 
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbc.update(sql, id);
    }
}

