
package controller;

/**
 *
 * @author noob
 */


import model.Vehicle;

import dao.OwnerRepository;
import dao.VehicleRepository;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    
    private final OwnerRepository ownerRepository;
    private final VehicleRepository vehicleRepository;
    
    public VehicleController(OwnerRepository ownerRepository, VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
        this.ownerRepository = ownerRepository;
    }
    
    
    //create - add vehicle
    @PostMapping
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        //ownerRepository.findById(vehicle.getOwnerId());
        vehicleRepository.createVehicle(vehicle);
        
        return ResponseEntity.ok("Vehicle added successfully");
    }
    
    
    //read - get vehicle by using owner id
    @GetMapping("/owner/{ownerId}")
    public List<Vehicle> getVehicleByOwner(@PathVariable int ownerId) {
        return vehicleRepository.readById(ownerId);
    }
    
    
    //update - update vehicle data 
    @GetMapping("/{id}")
    public ResponseEntity<String> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        vehicle.setOwnerId(id);
        vehicleRepository.updateVehicle(vehicle);
        
        return ResponseEntity.ok("Data updated successfully");
    }
    
    
    //delete - delete vehicle data
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        vehicleRepository.deleteVehicle(id);
        
        return ResponseEntity.ok("Vehicle deleted successfully");
    }
}
