package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository; // Assuming there's a repository for DB operations

    // Insert a new employee
    public Employee insert(Employee employee) {
        // Logic to save the employee (assuming repository or database interaction)
        return employeeRepository.save(employee);
    }

    // Get all employees
    public List<Employee> getall() {
        // Logic to fetch all employees from the database
        return employeeRepository.findAll();
    }

    // Get an employee by ID
    public Employee getEmployeeById(int id) {
        // Fetch the employee based on the ID
        return employeeRepository.findById(id).orElse(null);  // Returns null if not found
    }

    // Update employee details
    public Employee updatebyName(Employee employee) {
        // Logic to update an employee
        if (employeeRepository.existsById(employee.getEid())) {
            return employeeRepository.save(employee);  // Update the employee
        } else {
            return null;  // Return null if employee not found
        }
    }

    // Delete an employee by ID
    public List<Employee> deleteById(int id) {
        // Logic to delete employee by ID
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        return employeeRepository.findAll();  // Return updated list of employees after deletion
    }
}
