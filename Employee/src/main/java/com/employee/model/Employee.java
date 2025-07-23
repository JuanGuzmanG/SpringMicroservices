package com.employee.Models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "Department_id")
    private Long DepartmentId;
}
