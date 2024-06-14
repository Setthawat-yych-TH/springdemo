package com.example.springdemo.Controller;

import com.example.springdemo.Dto.EmployeeAddRequest;
import com.example.springdemo.Dto.EmployeeListResponse;
import com.example.springdemo.Entity.EmployeeEntity;
import com.example.springdemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/employee/getAll")
    public EmployeeListResponse getAllEmployee(){
        return employeeService.getAll();
    }

    @PostMapping(value = "/employee/add")
    public String addEmployee(@RequestBody EmployeeAddRequest employeeAddRequest){
        return employeeService.addEmployee(employeeAddRequest);
    }


}
