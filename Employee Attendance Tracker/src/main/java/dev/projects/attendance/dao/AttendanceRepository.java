
package dev.projects.attendance.dao;

/**
 *
 * @author noob
 */


import dev.projects.attendance.model.AttendanceSheet;

import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;


@Repository
public class AttendanceRepository {
    
    private final JdbcTemplate jdbc;
       
    //contructor based injection
    public AttendanceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    
    //create 
    public void createAttendance(AttendanceSheet attendanceSheet) {
        String sql = "INSERT INTO sheet(employeeId, date, status) VALUES(?,?,?)";
        jdbc.update(sql, attendanceSheet.getEmployeeId(), attendanceSheet.getDate(), attendanceSheet.getStatus());
    }
    
    
    //read by id
    public List<AttendanceSheet> readById(int id) {
        String sql = "SELECT * FROM sheet WHERE employeeId = ?";
        List<AttendanceSheet> attendanceSheet = jdbc.query(sql, new BeanPropertyRowMapper<>(AttendanceSheet.class), id);
        return attendanceSheet;
    }
    
    
    //read by all
    public List<AttendanceSheet> readAll() {
        String sql = "SELECT * FROM sheet";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(AttendanceSheet.class));
    }
}
