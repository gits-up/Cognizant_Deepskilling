package com.cognizant.EmployeeManagementSystem.repository;

import com.cognizant.EmployeeManagementSystem.dto.EmployeeNameEmailDTO;
import com.cognizant.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.cognizant.EmployeeManagementSystem.projection.EmployeeNameEmailProjection;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	List<EmployeeNameEmailProjection> findByDepartmentName(String departmentName);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<EmployeeNameEmailDTO> findFormattedEmployees(String departmentName);

//	    Page<Employee> findAll(Pageable pageable);


//    List<Employee> findByName(String name);
//    List<Employee> findByEmailContaining(String keyword);
//    List<Employee> findByDepartmentName(String deptName);
//
//    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
//    List<Employee> searchByName(@Param("name") String name);
//
//    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
//    List<Employee> getEmployeesByDept(@Param("deptName") String deptName);
}
