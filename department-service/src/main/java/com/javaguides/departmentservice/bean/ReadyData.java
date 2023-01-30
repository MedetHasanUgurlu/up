package com.javaguides.departmentservice.bean;

import com.javaguides.departmentservice.entity.Department;
import com.javaguides.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ReadyData {
    private final DepartmentRepository repository;
    @Bean
    CommandLineRunner readyDepartmentData(){
        return args -> {
            Department department = Department.builder().departmentCode("IT").departmentDescription("Information Technology").departmentName("IT001").build();
            Department department2 = Department.builder().departmentCode("AR-GE").departmentDescription("Research and Developing").departmentName("AR-GE001").build();
            Department department3 = Department.builder().departmentCode("AR-GE").departmentDescription("Information Technology").departmentName("AR-GE002").build();
            Department department4 = Department.builder().departmentCode("IT").departmentDescription("Information Technology").departmentName("IT002").build();
            Department department5 = Department.builder().departmentCode("IT").departmentDescription("Information Technology").departmentName("IT003").build();
            repository.save(department);
            repository.save(department2);
            repository.save(department3);
            repository.save(department4);
            repository.save(department5);

        };
    }
}
