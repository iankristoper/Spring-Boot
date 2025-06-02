package controller;

/**
 *
 * @author noob
 */



import dao.OwnerRepository;

import model.Owner;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;




@RestController
@RequestMapping("/owner")
public class OwnerController {
    
    public final OwnerRepository ownerRepository;
    
    public OwnerController(OwnerRepository ownerRepository) { //contructor based injection 
        this.ownerRepository = ownerRepository;
    }
    
    
    //create - post
    @PostMapping
    public ResponseEntity<String> createOwner(@RequestBody Owner owner) {
        ownerRepository.createOwner(owner);
        return ResponseEntity.ok("Owner created successfully");      
    }
    
    
    //read by id - get by id using pathvariable
    @GetMapping("/{id}")
    public Owner readOwnerById(@PathVariable int id) {
        return ownerRepository.readById(id);
    }
    
    
    //read all data
    @GetMapping
    public List<Owner> readAllData() {
        return ownerRepository.readAll();
    }
    
    
    //delete data - delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwnerData(@PathVariable int id) {
        ownerRepository.deleteOwner(id);
        return ResponseEntity.ok("Owner data deleted successfully");
    }
}
