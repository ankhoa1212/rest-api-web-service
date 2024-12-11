package com.example.restservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    EmployeeController employeeController;

    Employee employee_1 = new Employee( 
        "1", 
        "Ada", 
        "Lovelace", 
        "alovelace@gmail.com",
        "Mrs.");
    Employee employee_2 = new Employee( 
        "2", 
        "Grace", 
        "Hopper", 
        "ghopper@gmail.com",
        "Dr."); 
    Employee employee_3 = new Employee( 
        "3", 
        "Alan", 
        "Turing", 
        "aturing@gmail.com",
        "Dr.");

    // unit test for GET request
    @Test
    public void getEmployees_success() throws Exception {
        List<Employee> employees = new ArrayList<>(Arrays.asList(employee_1, employee_2, employee_3));
        Employees testEmployees = new Employees();
        testEmployees.setEmployeeList(employees);
        Mockito.when(employeeController.getEmployees()).thenReturn(testEmployees);
        mockMvc.perform(MockMvcRequestBuilders
        .get("/employees/")
        .accept(MediaType.ALL))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", notNullValue()));
    }

    // unit test for POST request
    @Test
    public void addEmployee_success() throws Exception {
        Employee testEmployee = new Employee("4", "Edsger", "Dijkstra", "edijkstra@gmail.com", "Dr.");
        Mockito.when(employeeController.addEmployee(testEmployee)).thenReturn(testEmployee);
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/employees/")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(testEmployee));
        mockMvc.perform(mockRequest)
            .andExpect(status().isOk());
    }
}
