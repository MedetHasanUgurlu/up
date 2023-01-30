package com.javaguides.employeeservice.service.impl;

import com.javaguides.employeeservice.bean.ModelMapperBean;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.model.ApiResponseModel;
import com.javaguides.employeeservice.model.DepartmentModel;
import com.javaguides.employeeservice.model.EmployeeModel;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.APIClient;
import com.javaguides.employeeservice.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;
    private final APIClient client;
    private final ModelMapperBean modelMapperbean;


    public Employee modelToEntity(EmployeeModel employeeModel){

        Employee employee = modelMapperbean.modelMapperMethod().map(employeeModel,Employee.class);
        return employee;
    }
    public EmployeeModel entityToModel(Employee employee){
        EmployeeModel employeeModel = modelMapperbean.modelMapperMethod().map(employee,EmployeeModel.class);
        return employeeModel;
    }



    @Override
    public ApiResponseModel createEmployee(EmployeeModel employeeModel) {
        Employee employee = modelToEntity(employeeModel);
        repository.save(employee);
        DepartmentModel departmentModel = client.getDepartment(employeeModel.getDepartmentCode());
        ApiResponseModel apiResponseModel = new ApiResponseModel();
        apiResponseModel.setEmployeeModel(employeeModel);
        apiResponseModel.setDepartmentModel(departmentModel);
        return apiResponseModel;
    }

    @Override
    public ApiResponseModel getEmployeeById(Long id) {
        Employee employee = repository.findById(id).get();
        EmployeeModel employeeModel1 = entityToModel(employee);
        DepartmentModel departmentModel = client.getDepartment(employeeModel1.getDepartmentCode());
        ApiResponseModel apiResponseModel = new ApiResponseModel();
        apiResponseModel.setEmployeeModel(employeeModel1);
        apiResponseModel.setDepartmentModel(departmentModel);
        return apiResponseModel;
    }

    @Override
    public List<ApiResponseModel> getEmployees() {
        return null;
    }
}
