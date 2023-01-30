package com.javaguides.departmentservice.business;
import java.util.List;

import com.javaguides.departmentservice.model.DepartmentModel;

public interface IDepartmentService {

    DepartmentModel createDepartment(DepartmentModel departmentModel);
    DepartmentModel getDepartmentById(Long id);
    void deleteDepartmentById(Long id);
    DepartmentModel getDepartmentByCode(String code);
    List<DepartmentModel> getDepartments();





}
