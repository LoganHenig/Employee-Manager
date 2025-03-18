package com.loganhenig.spring_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.loganhenig.spring_project.model.Department;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.loganhenig.spring_project.repositories.DepartmentRespoitory;
import com.loganhenig.spring_project.services.DepartmentService;



@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public ResponseEntity<?> createDepartment(@Valid @RequestBody Department department) {    
        try{
            return ResponseEntity.ok(departmentService.createDepartment(department));
        }
        catch(IllegalArgumentException err){
            return ResponseEntity.badRequest().body("Department already exists.");
        }
    }
    
    
    
}
