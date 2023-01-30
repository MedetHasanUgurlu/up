package com.javaguides.employeeservice.controller;

import com.javaguides.employeeservice.model.ApiResponseModel;
import com.javaguides.employeeservice.model.EmployeeModel;
import org.springframework.http.ResponseEntity;

public interface IEmployeeController {
    ResponseEntity<ApiResponseModel> createEmployee(EmployeeModel employeeModel);
    ResponseEntity<ApiResponseModel> getEmployeeById(Long id);
}
