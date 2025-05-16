package com.example.SMS.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Department_Details")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Course;
}
