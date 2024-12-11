package com.example.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Repository
@RestController
@RequestMapping(path = "/employees") // set mapping path
public class EmployeeController {

    @Autowired
    private EmployeeManager employeeManager;
    
    @GetMapping( // GET request
        path = "/",
        produces = "application/json" // produce json format
        )
    public Employees getEmployees() {
        return employeeManager.getAllEmployees();
    }

    @PostMapping( // POST request
        path = "/",
        consumes = "application/json", // receive json format
        produces = "application/json" // produce json format
        )
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeManager.addEmployee(employee);
        return employee;
    }
}
