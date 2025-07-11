package com.cognizant.spring_learn.rest_handson.fourth.service;

import com.cognizant.spring_learn.rest_handson.fourth.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.rest_handson.fourth.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {

    private static List<Employee> EMPLOYEES = new ArrayList<>();

    public void deleteEmployeeById(int id) {
        Iterator<Employee> iterator = EMPLOYEES.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
    }

    public void addDummyEmployee(Employee employee) {
        EMPLOYEES.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEES;
    }
}
