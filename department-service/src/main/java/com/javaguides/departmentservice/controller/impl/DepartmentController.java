package com.javaguides.departmentservice.controller.impl;

import com.javaguides.departmentservice.business.IDepartmentService;
import com.javaguides.departmentservice.controller.IDepartmentController;
import com.javaguides.departmentservice.model.DepartmentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController implements IDepartmentController {
    private final IDepartmentService service;





    @PostMapping
    @Override
    public ResponseEntity<DepartmentModel> createDepartment(@RequestBody DepartmentModel departmentModel) {
        return new ResponseEntity<>(service.createDepartment(departmentModel),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentModel> getDepartmentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getDepartmentById(id),HttpStatus.OK);
    }


    @Override
    @GetMapping("/all")
    public ResponseEntity<List<DepartmentModel>> getDepartments() {
        return new ResponseEntity<>(service.getDepartments(),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<DepartmentModel> getDepartmentByCode(@RequestParam String code) {
        return new ResponseEntity<>(service.getDepartmentByCode(code),HttpStatus.OK);
    }


}
