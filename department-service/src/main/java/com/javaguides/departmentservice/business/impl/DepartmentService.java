package com.javaguides.departmentservice.business.impl;

import com.javaguides.departmentservice.bean.ModelMapperBean;
import com.javaguides.departmentservice.business.IDepartmentService;
import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.model.DepartmentModel;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository repository;
    private final ModelMapperBean modelMapperBean;


    public DepartmentModel entityToModel(Department department){
        DepartmentModel departmentModel = modelMapperBean.modelMapperMethod().map(department,DepartmentModel.class);
        return departmentModel;
    }
    public Department modelToEntity(DepartmentModel departmentModel){
        Department department = modelMapperBean.modelMapperMethod().map(departmentModel,Department.class);
        return department;
    }


    @Override
    public DepartmentModel createDepartment(DepartmentModel departmentModel) {
        Department department = modelToEntity(departmentModel);
        repository.save(department);
        return departmentModel;
    }



    @Override
    public DepartmentModel getDepartmentById(Long id) {
        Department department = repository.findById(id).get();
        DepartmentModel departmentModel = entityToModel(department);
        return departmentModel;
    }

    @Override
    public void deleteDepartmentById(Long id) {
        Department department = repository.findById(id).get();
        repository.delete(department);
    }

    @Override
    public DepartmentModel getDepartmentByCode(String code) {
        Department department = repository.getDepartmentByDepartmentName(code);
        DepartmentModel departmentModel = entityToModel(department);
        return departmentModel;
    }

    @Override
    public List<DepartmentModel> getDepartments() {
        List<DepartmentModel> list = new ArrayList<>();
        repository.findAll().forEach((department -> list.add(entityToModel(department))));
        return list;
    }

}
