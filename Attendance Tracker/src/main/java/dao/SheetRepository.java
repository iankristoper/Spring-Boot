
package dao;

/**
 *
 * @author noob
 */


import model.Sheet;

import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;


@Repository
public class SheetRepository {
    
    private final JdbcTemplate jdbc;
    
    public SheetRepository(JdbcTemplate jdbc) { //the same which is depende automatic dependency injection 
        this.jdbc = jdbc;
    }
    
    
    //create 
    public int createSheet(Sheet sheet) {
        String sql = "INSERT INTO attendance(employeeId, date, status) VALUES(?,?,?)";
        return jdbc.update(sql, 
                sheet.getUserId(), 
                sheet.getLocalDate(), 
                sheet.getStatus());
    }
    
    
    //read -> by id 
    public List<Sheet> getSheetId(int id) {
        String sql = "SELECT * FROM attendance WHERE id=?";
        return (List) jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Sheet.class), id);
    }
    
    
    //read -> all
    public List<Sheet> getAllSheet() {
        String sql = "SELECT * FROM attendance";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Sheet.class));
    }
    
    
    //update -> update attendance details 
    public int updateSheet(Sheet sheet) {
        String sql = "UPDATE attendance SET empoyeeId=?, date=?, status=? WHERE id=?";
        return jdbc.update(sql, 
                sheet.getUserId(), 
                sheet.getLocalDate(), 
                sheet.getStatus(), 
                sheet.getId());
    }
    
    //delete -> delete attendance record
    public int deleteSheet(int id) {
        String sql = "DELETE FROM attendance WHERE id=?";
        return jdbc.update(sql, id);
    }
}
