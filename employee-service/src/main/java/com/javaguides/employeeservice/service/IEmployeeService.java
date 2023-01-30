package com.javaguides.employeeservice.service;

import com.javaguides.employeeservice.model.ApiResponseModel;
import com.javaguides.employeeservice.model.EmployeeModel;

import java.util.List;

public interface IEmployeeService {

    ApiResponseModel createEmployee(EmployeeModel employeeModel);
    ApiResponseModel getEmployeeById(Long id);
    List<ApiResponseModel> getEmployees();

}
