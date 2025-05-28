package org.jdbc.companypayroll;




import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  //for database row to java objects vice versa
import org.springframework.jdbc.core.JdbcTemplate;  //for core functions
import org.springframework.stereotype.Repository;  //tells the spring this is DAO



@Repository
public class DataRepository {
    
    private final JdbcTemplate jdbc;
    
    public DataRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    
    //CRUD METHODS
    
    //CREATE
    public void createData(CompanyData companyData) {
        String sql = "INSERT INTO companydata(id, name, position, salary) VALUES(?,?,?,?)";
        
        jdbc.update(sql, companyData.getId(), companyData.getName(), companyData.getPosition(), companyData.getSalary());
        System.out.println("Data has been inserted in DB successfully");
        System.out.println("");
    }
    
    //READ -> by ID
    public CompanyData readDataById(int id) {
        String sql = "SELECT * FROM companydata WHERE id=?";
        return jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(CompanyData.class), id);
    }
    
    //READ -> All data
    public List<CompanyData> readAllData() {
        String sql = "SELECT * FROM companydata";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(CompanyData.class));
    }
    
    //UPDATE
    public void updateData(CompanyData companyData) {
        String sql = "UPDATE companydata SET name=?, position=?, salary=? WHERE id=?";
        int result = jdbc.update(sql, companyData.getName(), companyData.getPosition(), companyData.getSalary(), companyData.getId());
        
        if(result > 0) {
            System.out.println("Data updated");
        } else {
            System.out.println("No matches in the ID");
        }
    }
    
    //DELETE
    public void deleteData(int id) {
        String sql = "DELETE FROM companydata WHERE id=?";
        int result = jdbc.update(sql, id);
        
        if(result > 0) {
            System.out.println("Data deleted from (ID): " + id);
        } else {
            System.out.println("No data matches on ID: " + id);
        }
    }
}
