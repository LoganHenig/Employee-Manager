package com.loganhenig.spring_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loganhenig.spring_project.model.Department;
import com.loganhenig.spring_project.repositories.DepartmentRespoitory;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRespoitory departmentRespoitory;

    public List<Department> getAllDepartments(){
        return departmentRespoitory.findAll();
    }
    public Department createDepartment(Department department){
        if(departmentRespoitory.existsByName(department.getName())){
            throw new IllegalArgumentException("Department already exists");
        }
        return departmentRespoitory.save(department);
    }
}
