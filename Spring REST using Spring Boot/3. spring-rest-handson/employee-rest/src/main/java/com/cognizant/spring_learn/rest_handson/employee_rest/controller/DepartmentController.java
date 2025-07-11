package com.cognizant.spring_learn.rest_handson.employee_rest.controller;

import com.cognizant.spring_learn.rest_handson.employee_rest.model.Department;
import com.cognizant.spring_learn.rest_handson.employee_rest.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("START getAllDepartments()");

        List<Department> list = departmentService.getAllDepartments();

        LOGGER.debug("Departments: {}", list);
        LOGGER.info("END getAllDepartments()");
        return list;
    }
}
