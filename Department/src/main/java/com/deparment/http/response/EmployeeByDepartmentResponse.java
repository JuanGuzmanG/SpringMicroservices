package com.deparment.http.response;

import com.deparment.controller.DTO.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeByDepartmentResponse {

    private String departmentName;
    private String departmentDescription;
    private List<EmployeeDTO> employees;
}
