package com.employee.services.Impl;

import com.employee.Models.Employee;
import com.employee.Persistence.EmployeeRepository;
import com.employee.controllers.DTO.EmployeeDTO;
import com.employee.services.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findALl() {
        ModelMapper modelMapper = new ModelMapper();
        return  employeeRepository.findAll()
                .stream()
                .map(employee ->
                        modelMapper.map(
                                employee, EmployeeDTO.class)
                ).collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDTO> findById(Long id) {

        if(employeeRepository.findById(id).isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            Employee employee = employeeRepository.findById(id).get();
            return Optional.of(modelMapper.map(employee, EmployeeDTO.class));
        }

        return Optional.empty();
    }

    @Override
    public List<EmployeeDTO> findAllByDepartmentId(Long departmentId) {

        ModelMapper modelMapper = new ModelMapper();
        List<Employee> employees = employeeRepository.findAllByDepartmentId(departmentId);
        if (!employees.isEmpty()) {
            return employees.stream()
                    .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                    .collect(Collectors.toList());
        }
        return List.of();
    }

    @Override
    public void save(EmployeeDTO employee) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Employee employeeEntity = modelMapper.map(employee, Employee.class);
            employeeRepository.save(employeeEntity);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving employee: " + e.getMessage());
        }
    }

    @Override
    public void update(Long id, EmployeeDTO employeeDTO) {
        if(employeeRepository.findById(id).isPresent()){
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setDepartmentId(employeeDTO.getDepartmentId());
            employeeRepository.save(employee);
        } else {
            throw new UnsupportedOperationException("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteById(Long id) {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
        } else {
            throw new UnsupportedOperationException("Employee with ID " + id + " not found.");
        }
    }
}
