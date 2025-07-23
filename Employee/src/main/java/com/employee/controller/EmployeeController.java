package com.employee.controllers;

import com.employee.Models.Employee;
import com.employee.controllers.DTO.EmployeeDTO;
import com.employee.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        return new ResponseEntity<>(this.employeeService.findALl(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeDTO>> findAllByDepartmentId(@PathVariable Long departmentId) {
        return new ResponseEntity<>(this.employeeService.findAllByDepartmentId(departmentId), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        employeeService.update(id, employeeDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@RequestBody Long id) {
        employeeService.deleteById(id);
    }
}
