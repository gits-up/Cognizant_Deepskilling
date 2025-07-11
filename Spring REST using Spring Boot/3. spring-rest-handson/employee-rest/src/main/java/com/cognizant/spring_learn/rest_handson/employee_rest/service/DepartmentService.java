package com.cognizant.spring_learn.rest_handson.employee_rest.service;

import com.cognizant.spring_learn.rest_handson.employee_rest.dao.DepartmentDao;
import com.cognizant.spring_learn.rest_handson.employee_rest.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }
}
