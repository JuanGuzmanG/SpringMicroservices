package com.deparment.client;

import com.deparment.controller.DTO.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-employee", url = "localhost:8090/api/employee")
public interface EmployeeCLient {

    @GetMapping("/department/{departmentId}")
    List<EmployeeDTO> findAllEmployeeByDepartmentId(@PathVariable Long departmentId);

}
