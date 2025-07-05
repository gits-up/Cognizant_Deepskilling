package com.cognizant.orm_learn_query.service;

import com.cognizant.orm_learn_query.model.Employee;
import com.cognizant.orm_learn_query.repository.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Double getAverageSalaryByDepartment(int deptId) {
        return employeeRepository.getAverageSalaryByDepartment(deptId);
    }


    public List<Employee> getHighestPaidEmployees() {
        return employeeRepository.getHighestPaidEmployees();
    }

}
