package com.deparment.service.Impl;

import com.deparment.client.EmployeeCLient;
import com.deparment.controller.DTO.DepartmentDTO;
import com.deparment.controller.DTO.EmployeeDTO;
import com.deparment.http.response.EmployeeByDepartmentResponse;
import com.deparment.model.Department;
import com.deparment.presistence.IDepartmentRepository;
import com.deparment.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeparmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private EmployeeCLient employeeCLient;

    @Override
    public List<DepartmentDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepartmentDTO> findById(Long id) {
        if(departmentRepository.findById(id).isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            Department department = departmentRepository.findById(id).get();
            return Optional.of(modelMapper.map(department, DepartmentDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Department department = modelMapper.map(departmentDTO, Department.class);
            departmentRepository.save(department);
            return departmentDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving department: " + e.getMessage());
        }
    }

    @Override
    public DepartmentDTO update(Long id, DepartmentDTO departmentDTO) {
        if(departmentRepository.findById(id).isPresent()){
            ModelMapper modelMapper = new ModelMapper();
            Department department = departmentRepository.findById(id).get();
            department.setName(departmentDTO.getName());
            department.setLocation(departmentDTO.getLocation());
            department.setDescription(departmentDTO.getDescription());
            department.setHeadOfDepartment(departmentDTO.getHeadOfDepartment());
            departmentRepository.save(department);
            return modelMapper.map(department, DepartmentDTO.class);
        } else {
            throw new UnsupportedOperationException("Department with ID " + id + " not found.");
        }
    }

    @Override
    public String delete(Long id) {
        if(departmentRepository.findById(id).isPresent()){
            departmentRepository.deleteById(id);
            return "Department with ID " + id + " deleted successfully.";
        }
        return "Department with ID " + id + " not found.";
    }

    @Override
    public EmployeeByDepartmentResponse findEmployeesByDepartmentId(Long id) {

        if (departmentRepository.findById(id).isPresent()) {
            Department department = departmentRepository.findById(id).orElseThrow();

            List<EmployeeDTO> employees = employeeCLient.findAllEmployeeByDepartmentId(id);

            return EmployeeByDepartmentResponse.builder()
                    .departmentName(department.getName())
                    .departmentDescription(department.getDescription())
                    .employees(employees)
                    .build();
        }
        return null;
    }
}
