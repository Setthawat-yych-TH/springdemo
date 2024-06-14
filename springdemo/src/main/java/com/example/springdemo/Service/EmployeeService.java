package com.example.springdemo.Service;

import com.example.springdemo.Dto.EmployeeAddRequest;
import com.example.springdemo.Dto.EmployeeListResponse;
import com.example.springdemo.Dto.EmployeeResponse;
import com.example.springdemo.Entity.EmployeeEntity;
import com.example.springdemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeListResponse getAll(){
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        EmployeeListResponse employeeListResponse = new EmployeeListResponse();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        for(EmployeeEntity employeeEntity : employeeEntityList) {
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setEmpId(employeeEntity.getEmpId());
            employeeResponse.setName(employeeEntity.getName());
            employeeResponse.setAge(employeeEntity.getAge());
            employeeResponse.setDepId(employeeEntity.getDepId());
            employeeResponse.setDepartment(employeeEntity.getDepartment());

            employeeResponseList.add(employeeResponse);

        }

        employeeListResponse.setEmployeeResponseList(employeeResponseList);
        System.out.println("TESTEST");
        return employeeListResponse;
    }

    public String addEmployee(EmployeeAddRequest requestBody){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(requestBody.getName());
        employeeEntity.setAge(requestBody.getAge());
        employeeEntity.setDepId(requestBody.getDepId());
        employeeEntity.setDepartment(requestBody.getDepartment());
        System.out.println(employeeEntity.getName());
        employeeRepository.save(employeeEntity);

        return "success";
    }
}
