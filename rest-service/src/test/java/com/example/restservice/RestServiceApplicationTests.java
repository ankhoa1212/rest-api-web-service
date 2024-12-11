package com.example.restservice;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class RestServiceApplicationTests {
    // TODO can add unit tests for greetings

	@Autowired
    private MockMvc mockMvc;

    // Simulate the JSON response from a GET request
    String jsonResponse = """
        {
          "employeeList" : [ {
            "id" : "1",
            "firstName" : "Ada",
            "lastName" : "Lovelace",
            "email" : "alovelace@gmail.com",
            "title" : "Mrs."
          }, {
            "id" : "2",
            "firstName" : "Grace",
            "lastName" : "Hopper",
            "email" : "ghopper@gmail.com",
            "title" : "Dr."
          }, {
            "id" : "3",
            "firstName" : "Alan",
            "lastName" : "Turing",
            "email" : "aturing@gmail.com",
            "title" : "Dr."
          } ]
        }""";

    // unit test for specific employee
    @Test
    public void testSpecificEmployee() throws IOException {

        // Create ObjectMapper to deserialize JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialize the JSON into EmployeeListResponse
        Employees response = objectMapper.readValue(jsonResponse, Employees.class);

        // Access employee with id "2"
        String employeeId = "2";
        Employee employee = response.getEmployeeList().stream()
                .filter(emp -> emp.getId().equals(employeeId))
                .findFirst()
                .orElse(null);

        // Assert that the employee is found and their details are correct
        assertNotNull(employee);
        assertEquals("2", employee.getId());
        assertEquals("Grace", employee.getFirstName());
        assertEquals("Hopper", employee.getLastName());
        assertEquals("ghopper@gmail.com", employee.getEmail());
        assertEquals("Dr.", employee.getTitle());
    }

    // unit test for GET request with String JSON
	@Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/") // Send GET request to /employees
                        .contentType(MediaType.APPLICATION_JSON_VALUE))  // Specify the content type
                .andExpect(MockMvcResultMatchers.status().isOk())  // Expect HTTP status 200 (OK)
                .andExpect(MockMvcResultMatchers.content().json(jsonResponse));
    }

    // unit test for POST request with String JSON
    @Test
    public void testAddEmployee() throws Exception {
        // Creating a new employee object as JSON payload
        String jsonString = """
            {
                "id" : "4",
                "firstName" : "Cherry",
                "lastName" : "Poppins",
                "email" : "cpoppins@gmail.com",
                "title" : "Mrs."
            }""";
        mockMvc.perform(MockMvcRequestBuilders.post("/employees/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)  // Specify the content type
                        .content(jsonString))  // Pass the JSON payload
                .andExpect(MockMvcResultMatchers.status().isOk())  // Expect HTTP status 200 (OK)
                .andExpect(MockMvcResultMatchers.content().json(jsonString));
    }
}
