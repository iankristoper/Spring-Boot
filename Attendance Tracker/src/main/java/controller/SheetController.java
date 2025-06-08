
package controller;

/**
 *
 * @author Ian Tagano
 */


import model.Sheet;

import dao.SheetRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;




@RestController
@RequestMapping("/attendance")
public class SheetController {
    
    private final SheetRepository sheetRepo;
    
    public SheetController(SheetRepository sheetRepo) {
        this.sheetRepo = sheetRepo;
    }
    
    
    //create -> POST create data
    @PostMapping
    public ResponseEntity<String> createSheet(Sheet sheet) {
        sheetRepo.createSheet(sheet);
        return ResponseEntity.ok("Attendance added successfully");
    } 
    
    
    //read -> GET by ID
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Sheet>> getSheetById(@PathVariable int employeeId) {
        List<Sheet> records = sheetRepo.getSheetId(employeeId);     
        return ResponseEntity.ok(records);
    }
    
    
    //read -> GET all data 
    @GetMapping
    public ResponseEntity<List<Sheet>> getAllData() {
        List<Sheet> allRecords = sheetRepo.getAllSheet();
        return ResponseEntity.ok(allRecords);   
    }
    
    
    //delete -> DELETE all data 
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSheet(@PathVariable int id) {
        sheetRepo.deleteSheet(id);
        return ResponseEntity.ok("Attendance has been deleted");
    }
    
}

