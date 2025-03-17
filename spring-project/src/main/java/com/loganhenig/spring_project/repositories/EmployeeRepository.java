package com.loganhenig.spring_project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loganhenig.spring_project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
    // Optional<Employee> findEmployeeById(long id);
    // Optional<Employee> createEmployee(Employee employee);
    // Optional<Employee> deleteEmployeeById(long id);
}
