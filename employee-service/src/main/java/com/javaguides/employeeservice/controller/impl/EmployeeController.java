package com.javaguides.employeeservice.controller.impl;

import com.javaguides.employeeservice.controller.IEmployeeController;
import com.javaguides.employeeservice.model.ApiResponseModel;
import com.javaguides.employeeservice.model.EmployeeModel;
import com.javaguides.employeeservice.service.impl.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController implements IEmployeeController {
    private final EmployeeService service;


    @Override
    @PostMapping
    public ResponseEntity<ApiResponseModel> createEmployee(@RequestBody EmployeeModel employeeModel) {
        return new ResponseEntity<>(service.createEmployee(employeeModel), HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseModel> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getEmployeeById(id),HttpStatus.OK);
    }
}
