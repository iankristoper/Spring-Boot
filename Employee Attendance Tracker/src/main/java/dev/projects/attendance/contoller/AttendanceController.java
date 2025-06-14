

package dev.projects.attendance.contoller;

/**
 *
 * @author noob
 */


import dev.projects.attendance.model.AttendanceSheet;
import dev.projects.attendance.dao.AttendanceRepository;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;



@RestController
@RequestMapping("/sheet")
public class AttendanceController {
    
    private final AttendanceRepository attendanceRepo;
    
    
    //contructor based injection
    public AttendanceController(AttendanceRepository attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }
    
    
    //create 
    @PostMapping
    public ResponseEntity<String> createAttendance(@RequestBody AttendanceSheet attendanceSheet) {
        attendanceRepo.createAttendance(attendanceSheet);
        return ResponseEntity.ok("Sheet recorded successfully");
    }
    
    
    //read by id
    @GetMapping("/{id}")
    public ResponseEntity<List<AttendanceSheet>> readById(@PathVariable int id) {
        List<AttendanceSheet> attendanceSheet = attendanceRepo.readById(id);
        return ResponseEntity.ok(attendanceSheet);
    }
    
    
    //read by all
    @GetMapping
    public ResponseEntity<List<AttendanceSheet>> readAll() {
        List<AttendanceSheet> attendanceSheet = attendanceRepo.readAll();
        return ResponseEntity.ok(attendanceSheet);
    }
    
    
    //delete attendance sheet
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSheet(@PathVariable int id) {
        attendanceRepo.deleteAttendance(id);
        return ResponseEntity.ok("Sheet deleted successfully");
    }
}

























