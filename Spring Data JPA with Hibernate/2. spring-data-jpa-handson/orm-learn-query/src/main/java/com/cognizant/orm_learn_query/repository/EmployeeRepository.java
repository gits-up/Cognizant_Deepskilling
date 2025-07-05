package com.cognizant.orm_learn_query.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn_query.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

//    List<Employee> findBySalaryGreaterThan(double salary);
//
//    List<Employee> findByDepartment(String department);
//
//    List<Employee> findByDateOfJoiningAfter(Date date);
}
