package RESTAPI.demo.controller;

import RESTAPI.demo.models.Employee;
import RESTAPI.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/Employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Object>  getEmployeeByName(@PathVariable String name){
        List<Optional<Employee>> emp=employeeService.getEmployeeByName(name);
        if(emp.size()==0)
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(emp);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
