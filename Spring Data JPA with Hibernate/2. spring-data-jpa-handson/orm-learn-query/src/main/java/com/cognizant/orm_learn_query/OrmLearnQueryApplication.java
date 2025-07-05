package com.cognizant.orm_learn_query;

import com.cognizant.orm_learn_query.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class OrmLearnQueryApplication {

    private static EmployeeService employeeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnQueryApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnQueryApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);

        testPrintAllEmployeesWithSkills();
    }

    private static void testPrintAllEmployeesWithSkills() {
        LOGGER.info("Start");
        employeeService.printAllEmployeesWithSkills();
        LOGGER.info("End");
    }
}
