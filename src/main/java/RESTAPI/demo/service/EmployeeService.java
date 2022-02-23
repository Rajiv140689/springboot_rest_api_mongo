package RESTAPI.demo.service;

import RESTAPI.demo.models.Employee;
import RESTAPI.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee){
        employeeRepository.insert(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee savedEmployee=employeeRepository.findById(employee.getId()).orElseThrow(
                ()-> new RuntimeException(String.format("Employee not found for id %s", employee.getId())));
        savedEmployee.setEmployeeName(employee.getEmployeeName());
        savedEmployee.setEmployeeTeam(employee.getEmployeeTeam());
        savedEmployee.setEmployeeDesignation(employee.getEmployeeDesignation());
        savedEmployee.setExperience(employee.getExperience());
        employeeRepository.save(savedEmployee);
        return savedEmployee;
    }


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public List<Optional<Employee>> getEmployeeByName(String name){
        return employeeRepository.findByName(name);

    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }

}
