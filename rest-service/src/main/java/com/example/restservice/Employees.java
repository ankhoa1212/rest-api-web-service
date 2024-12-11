package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employees;
    public List<Employee> getEmployeeList() {
        if (employees == null) {
            employees = new ArrayList<>();
        }
        return employees;
    }
    public void setEmployeeList(List<Employee> employeeList) {
        this.employees = employeeList;
    }
}
