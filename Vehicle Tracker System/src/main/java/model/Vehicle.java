
package model;

/**
 *
 * @author noob
 */


public class Vehicle {
    
    private int ownerId;
    private int vehicleId;
    private String vehicleModel;
    private String vehiclePlate;
    private int vehicleYear;
    
    //constructor
    public Vehicle() { 
           
    }
    
    public Vehicle(int ownerId, int vehicleId, String vehicleModel, String vehiclePlate, int vehicleYear) {
        this.ownerId = ownerId;
        this.vehicleId = vehicleId;
        this.vehicleModel = vehicleModel;
        this.vehiclePlate = vehiclePlate;
    }
    
    //getters and setters 
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    public int getOwnerId() {
        return ownerId;
    }
    
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public int getVehicleId() {
        return vehicleId;
    }
    
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    public String getVehicleModel() {
        return vehicleModel;
    }
    
    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }
    
    public String getVehiclePlate() {
        return vehiclePlate;
    }
    
    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }
    
    public int getVehicleYear() {
        return vehicleYear;
    } 
}
