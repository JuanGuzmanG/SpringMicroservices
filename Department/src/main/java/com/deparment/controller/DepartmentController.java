package com.deparment.controller;

import com.deparment.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @GetMapping("/find/all")
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return new ResponseEntity<>(this.departmentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.findById(id).orElseThrow(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public void save(DepartmentDTO departmentDTO) {
        departmentService.save(departmentDTO);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        departmentService.update(id, departmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(departmentService.delete(id), HttpStatus.OK);
    }
}
