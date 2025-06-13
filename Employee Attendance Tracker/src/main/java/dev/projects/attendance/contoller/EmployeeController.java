
package dev.projects.attendance.contoller;

/**
 *
 * @author Ian Tagano
 */


import dev.projects.attendance.model.Employee;
import dev.projects.attendance.dao.EmployeeRepository;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;

import java.util.List;




@RestController
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeRepository employeeRepo;
    
    public EmployeeController(EmployeeRepository employeeRepo) {  //constructor based injection
        this.employeeRepo = employeeRepo;
    }
    
    
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeRepo.createEmployee(employee);
        return ResponseEntity.ok("Emplyee added perfectly");
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Employee> readIdEmployee(@PathVariable int id) {
        Employee employee = employeeRepo.readById(id);
        return ResponseEntity.ok(employee);
    }
    
    
    @GetMapping
    public ResponseEntity<List<Employee>> readAllEmployee() {
        List<Employee> employee = employeeRepo.readAll();
        return ResponseEntity.ok(employee);
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeRepo.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
       
    
    /**for test**\
    
    @GetMapping
    public String hello() {
        return "This is test";
    }
    
    */
}
