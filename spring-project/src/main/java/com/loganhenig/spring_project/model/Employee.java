package com.loganhenig.spring_project.model;

import com.loganhenig.spring_project.services.DepartmentService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="Name is required")
    @Size(min=2,max=100, message="Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message="Email is required")
    @Email(message="Invalid email format")
    @Column(unique=true, nullable=false)
    private String email;

    @NotNull(message="Salary is required")
    @DecimalMin(value = "30000.00", message = "Salary must be at least 30,000")
    @DecimalMax(value = "500000.00", message = "Salary must be less than 500,000")
    private Double salary;

    // @NotNull(message="Department ID is required")
    // @ManyToOne
    // @JoinColumn(name = "department_id")
    // private Department department;
    
}
