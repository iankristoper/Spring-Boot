
package dev.projects.attendance.dao;

/**
 *
 * @author noob
 */


import dev.projects.attendance.model.AttendanceSheet;
import dev.projects.attendance.model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;
import org.springframework.jdbc.core.RowMapper;


@Repository
public class AttendanceRepository {
    
    private final JdbcTemplate jdbc;
       
    //contructor based injection
    public AttendanceRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    
    //using rowmapper 
    public class SheetRowMapper implements RowMapper<AttendanceSheet> {
        
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            AttendanceSheet sheetRow = new AttendanceSheet();
            sheetRow.setId(rs.getInt("id"));
            sheetRow.setEmployeeId(rs.getInt("employeeId"));
            sheetRow.setDate(rs.getDate(""));
            sheetRow.setStatus(rs.);
        }
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
    
    
    //delete
    public void deleteAttendance(int id) {
        String sql = "DELETE FROM sheet WHERE id = ?";
        jdbc.update(sql, id);
    }
    
}


































