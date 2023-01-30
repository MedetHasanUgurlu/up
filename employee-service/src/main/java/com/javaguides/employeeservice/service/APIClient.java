package com.javaguides.employeeservice.service;


import com.javaguides.employeeservice.model.DepartmentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://localhost:8080/api/departments/,http://localhost:8081/api/departments/",name = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping
    DepartmentModel getDepartment(@RequestParam String code);




}
