package com.cognizant.EmployeeManagementSystem.service;

import com.cognizant.EmployeeManagementSystem.dto.EmployeeNameEmailDTO;
import com.cognizant.EmployeeManagementSystem.model.Employee;
import com.cognizant.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cognizant.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public Page<Employee> getAllEmployeesPaged(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<EmployeeNameEmailProjection> findNameEmailByDept(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    public List<EmployeeNameEmailDTO> getFormattedEmployees(String deptName) {
        return employeeRepository.findFormattedEmployees(deptName);
    }
    
    public void addBulkEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

//    public List<Employee> findByName(String name) {
//        return employeeRepository.findByName(name);
//    }
//
//    public List<Employee> findByEmailContaining(String keyword) {
//        return employeeRepository.findByEmailContaining(keyword);
//    }
//
//    public List<Employee> findByDepartmentName(String deptName) {
//        return employeeRepository.findByDepartmentName(deptName);
//    }
//
//    public List<Employee> searchByName(String name) {
//        return employeeRepository.searchByName(name);
//    }
//
//    public List<Employee> getEmployeesByDept(String deptName) {
//        return employeeRepository.getEmployeesByDept(deptName);
//    }
}
