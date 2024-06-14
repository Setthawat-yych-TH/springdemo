package com.example.springdemo.Dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeListResponse {
    List<EmployeeResponse> employeeResponseList;
}
