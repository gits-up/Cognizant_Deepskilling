package com.cognizant.orm_learn_query.service;

import java.util.List;

import com.cognizant.orm_learn_query.model.Department;
import com.cognizant.orm_learn_query.model.Employee;
import com.cognizant.orm_learn_query.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void printDepartmentAndEmployees(int deptId) {
        Department department = departmentRepository.findById(deptId).orElse(null);
        if (department != null) {
            LOGGER.debug("Department: {}", department.getName());

            List<Employee> employees = department.getEmployees();
            employees.forEach(emp -> LOGGER.debug("Employee: {}", emp));
        } else {
            LOGGER.warn("Department with ID {} not found", deptId);
        }
    }
}
