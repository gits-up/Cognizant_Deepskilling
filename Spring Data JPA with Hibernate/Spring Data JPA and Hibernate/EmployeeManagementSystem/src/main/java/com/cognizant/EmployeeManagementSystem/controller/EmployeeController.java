package com.cognizant.EmployeeManagementSystem.controller;

import com.cognizant.EmployeeManagementSystem.dto.EmployeeNameEmailDTO;
import com.cognizant.EmployeeManagementSystem.model.Employee;
import com.cognizant.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.cognizant.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
    
    @GetMapping("/paged")
    public Page<Employee> getEmployeesPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                                                      : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeService.getAllEmployeesPaged(pageable);
    }
    
    @GetMapping("/projection/interface")
    public List<EmployeeNameEmailProjection> getInterfaceProjection(@RequestParam String deptName) {
        return employeeService.findNameEmailByDept(deptName);
    }

    @GetMapping("/projection/class")
    public List<EmployeeNameEmailDTO> getClassProjection(@RequestParam String deptName) {
        return employeeService.getFormattedEmployees(deptName);
    }
    
    @PostMapping("/bulk")
    public String addBulk(@RequestBody List<Employee> employees) {
        employeeService.addBulkEmployees(employees);
        return "Bulk insert done";
    }


//    @GetMapping("/by-name")
//    public List<Employee> findByName(@RequestParam String name) {
//        return employeeService.findByName(name);
//    }
//
//    @GetMapping("/search-email")
//    public List<Employee> findByEmailContaining(@RequestParam String keyword) {
//        return employeeService.findByEmailContaining(keyword);
//    }
//
//    @GetMapping("/by-department")
//    public List<Employee> findByDepartmentName(@RequestParam String name) {
//        return employeeService.findByDepartmentName(name);
//    }
//
//    @GetMapping("/search-name")
//    public List<Employee> searchByName(@RequestParam String name) {
//        return employeeService.searchByName(name);
//    }
//
//    @GetMapping("/dept")
//    public List<Employee> getEmployeesByDept(@RequestParam String name) {
//        return employeeService.getEmployeesByDept(name);
//    }
}
