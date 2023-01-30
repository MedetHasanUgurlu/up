package com.javaguides.employeeservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String departmentCode;
}
