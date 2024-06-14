package com.example.springdemo.Dto;

import lombok.Data;

@Data
public class EmployeeResponse {
    private Integer empId;
    private String name;
    private Integer age;
    private Integer depId;
    private String department;
}
