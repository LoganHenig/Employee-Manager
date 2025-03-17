package com.loganhenig.spring_project.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loganhenig.spring_project.SpringProjectApplication;
import com.loganhenig.spring_project.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.loganhenig.spring_project.services.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired 
    private EmployeeService employeeService;
    
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
        Employee savedEmployee = employeeService.createEmployee(emp);
        return ResponseEntity.ok(savedEmployee);
    }   
}
