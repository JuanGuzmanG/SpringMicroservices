package com.deparment.presistence;

import com.deparment.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department, Long> {

    List<Department> findAll();
}
