package com.cognizant.spring_learn.rest_handson.fourth.controller;

import com.cognizant.spring_learn.rest_handson.fourth.model.Employee;
import com.cognizant.spring_learn.rest_handson.fourth.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeService employeeService;


    @PutMapping
    public Employee updateEmployee(@RequestBody @Valid Employee employee) {
        LOGGER.info("START updateEmployee()");
        LOGGER.debug("Employee: {}", employee);
        LOGGER.info("END updateEmployee()");
        return employee;
    }
    
    
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        LOGGER.info("START deleteEmployee()");
        employeeService.deleteEmployeeById(id);
        LOGGER.info("END deleteEmployee()");
    }

}
