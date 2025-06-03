package dao;


/**
 *
 * @author noob
 */


import model.Vehicle;
import model.Owner;

import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;






@Repository
public class VehicleRepository {
    
    private final JdbcTemplate jdbc;
    
    public VehicleRepository(JdbcTemplate jdbc) {  //for dependency injection - contructor based no autowrd
        this.jdbc = jdbc;
    }
    
    //create 
    public String createVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO vehicle WHERE vehicle(ownerId, vehicleModel, vehiclePlate, vehicleYear) VALUES(?,?,?,?)";
        jdbc.update(sql, vehicle.getOwnerId(), vehicle.getVehicleModel(), vehicle.getVehiclePlate(), vehicle.getVehicleYear());
        
        return "Vehicle Created";
    }
    
    
    //read all
    public List<Vehicle> readAll() {
        String sql = "SELECT * FROM vehicle";
        return jdbc.query(sql, new BeanPropertyRowMapper<>(Vehicle.class));
    }
    
    
    //read by id
    public List<Vehicle> readById(int ownerId) {
        String sql = "SELECT FROM vehicle WHERE ownerId=?";
        return (List<Vehicle>) jdbc.queryForObject(sql, new BeanPropertyRowMapper<>(Vehicle.class), ownerId);
    }
    
    
    //update
    public String updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET vehicleModel=?, vehiclePlate=?, vehicleYear=? WHERE vehicleId=?";
        int result = jdbc.update(sql, vehicle.getVehicleModel(), vehicle.getVehiclePlate(), vehicle.getVehicleYear(), vehicle.getVehicleId());
        
        if(result > 0) {
            return "Vehicle updated successfully";
        } else {
            return "Vehicle ID do not match";
        }
    }
    
    
    //delete 
    public String deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM vehicle WHERE vehicleId=?";
        int result = jdbc.update(sql, vehicleId);
        
        if(result > 0) {
            return "Vehicle deleted successfully";
        } else {
            return "No vehicle ID match from the database";
        }
    }
}
