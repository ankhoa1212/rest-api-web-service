package com.example.restservice;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
    private static final Employees employeeList = new Employees();
    static {
        employeeList.getEmployeeList().add(
        new Employee( 
            "1", 
        "Ada", 
        "Lovelace", 
        "alovelace@gmail.com",
        "Mrs."));
        employeeList.getEmployeeList().add( 
        new Employee( 
            "2", 
        "Grace", 
        "Hopper", 
        "ghopper@gmail.com",
        "Dr.")); 
        employeeList.getEmployeeList().add( 
        new Employee( 
            "3", 
        "Alan", 
        "Turing", 
        "aturing@gmail.com",
        "Dr."));
    }
    public Employees getAllEmployees() {
        return employeeList;
    }

    public void addEmployee(Employee employee) {
        employeeList.getEmployeeList().add(employee);
    }
}
