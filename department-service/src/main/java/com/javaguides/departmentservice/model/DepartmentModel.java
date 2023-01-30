package com.javaguides.departmentservice.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentModel {
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
