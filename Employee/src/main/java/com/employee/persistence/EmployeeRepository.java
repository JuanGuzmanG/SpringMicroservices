package com.employee.persistence;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.id = :DepartmentId")
    List<Employee> findAllByDepartmentId(Long DepartmentId);

    List<Employee> findAll();
}
