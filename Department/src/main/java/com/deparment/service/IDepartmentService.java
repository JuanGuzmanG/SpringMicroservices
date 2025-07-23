package com.deparment.service;

import com.deparment.controller.DTO.DepartmentDTO;
import com.deparment.http.response.EmployeeByDepartmentResponse;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    List<DepartmentDTO> findAll();

    Optional<DepartmentDTO> findById(Long id);

    DepartmentDTO save(DepartmentDTO departmentDTO);

    DepartmentDTO update(Long id, DepartmentDTO departmentDTO);

    String delete(Long id);

    EmployeeByDepartmentResponse findEmployeesByDepartmentId(Long id);
}
