package com.javaguides.departmentservice.repository;

import com.javaguides.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department getDepartmentByDepartmentName(String code);

}
