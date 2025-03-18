package com.loganhenig.spring_project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "departments")
public class Department {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    @NotBlank(message="Name is a required field")
    @Size(min=2,max = 25, message = "Name must be at least 2 characters and less than 25")
    private String name;

    private String description;

    // @OneToMany(mappedBy="department", cascade = CascadeType.ALL, orphanRemoval=true)
    // private List<Employee> employees;
    
}
