package com.javaguides.departmentservice.controller;

import com.javaguides.departmentservice.model.DepartmentModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDepartmentController {

    ResponseEntity<DepartmentModel> createDepartment(DepartmentModel departmentModel);
    ResponseEntity<DepartmentModel> getDepartmentById(Long id);
    ResponseEntity<List<DepartmentModel>> getDepartments();
    ResponseEntity<DepartmentModel> getDepartmentByCode(String code);

}
