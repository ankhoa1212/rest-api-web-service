package com.example.restservice;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "firstName", "lastName", "email", "title" }) // format json property display order
public class Employee {
    public Employee() {}

    public Employee(
        String employee_id, String first_name,
        String last_name, String email, String title)
    {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.title = title;
    }
    private String employee_id;
    private String first_name;
    private String last_name;
    private String email;
    private String title;

    @Override
    public String toString()
    {
        return "Employee: ID = "
            + employee_id + ", First Name = "
            + first_name + ", Last Name = "
            + last_name + ", email = "
            + email + ", title = "
            + title;      
    }

    public String getId() {
        return employee_id;
    }

    public void setId(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
