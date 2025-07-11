package com.cognizant.spring_learn.rest_handson.employee_rest;

import com.cognizant.spring_learn.rest_handson.employee_rest.dao.EmployeeDao;
import com.cognizant.spring_learn.rest_handson.employee_rest.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EmployeeRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRestApplication.class, args);

        EmployeeDao dao = new EmployeeDao();
        List<Employee> employees = dao.getAllEmployees();

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
