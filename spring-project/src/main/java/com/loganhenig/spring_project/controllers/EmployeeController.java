package com.loganhenig.spring_project.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loganhenig.spring_project.SpringProjectApplication;
import com.loganhenig.spring_project.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    private final DepartmentController departmentController;

    @Autowired 
    private EmployeeService employeeService;

    EmployeeController(DepartmentController departmentController) {
        this.departmentController = departmentController;
    }
    
    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @PostMapping("/")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee emp) {
        System.out.println(emp);
        try{
            return ResponseEntity.ok(employeeService.createEmployee(emp));
        }
        catch(IllegalArgumentException e){
                return ResponseEntity.badRequest().body("Email already exists");
        }
    }   
}
