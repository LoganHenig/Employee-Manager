package com.loganhenig.spring_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loganhenig.spring_project.model.Department;

public interface DepartmentRespoitory extends JpaRepository<Department, Long> {
    
}
