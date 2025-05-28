package org.jdbc.companypayroll;



import org.springframework.web.bind.annotation.*;
import java.util.List;




//this is the interaction in WEB API and the REPOSITORY unto the DATABASE
@RestController //-> tells java that this is one of annotation that let spring handles this 
@RequestMapping("/payroll")
public class DataController {
    
    private final DataRepository repo;
    
    public DataController(DataRepository repo) { //->we inject user repository for this class to interact with it
        this.repo = repo;
    }
    
    //CREATE -> POST
    @PostMapping
    public String createData(@RequestBody CompanyData companyData) {
        repo.createData(companyData);
        return "Data inserted successfully from user end (postman or html)";
    }
    
    //READ -> GET
    @GetMapping("/{id}")
    public CompanyData getData(@PathVariable int id) {
        return repo.readDataById(id);
    }
    
    //READ ALL -> GET
    @GetMapping
    public List<CompanyData> getAllData() {
        return repo.readAllData();
    }
    
    //UPDATE -> PUT
    @PutMapping
    public String updateData(@PathVariable int id, @RequestBody CompanyData companydata) {
        companydata.setId(id);
        repo.updateData(companydata);
        return "Data updated";
    }
    
    //DELETE -> DELETE
    @DeleteMapping("/{id}")
    public String deleteData(@PathVariable int id) {
        repo.deleteData(id);
        return "Data deleted";
    }
    
    
    
}
