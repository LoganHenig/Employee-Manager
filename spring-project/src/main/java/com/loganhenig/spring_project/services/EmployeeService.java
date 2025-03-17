package com.loganhenig.spring_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.loganhenig.spring_project.repositories.EmployeeRepository;
import com.loganhenig.spring_project.model.Employee;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

}
