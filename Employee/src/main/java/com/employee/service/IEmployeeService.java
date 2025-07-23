package com.employee.services;

import com.employee.controllers.DTO.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<EmployeeDTO> findALl();

    Optional<EmployeeDTO> findById(Long id);

    List<EmployeeDTO> findAllByDepartmentId(Long departmentId);

    void save(EmployeeDTO employeeDTO);

    void update(Long id, EmployeeDTO employeeDTO);

    void deleteById(Long id);
}
