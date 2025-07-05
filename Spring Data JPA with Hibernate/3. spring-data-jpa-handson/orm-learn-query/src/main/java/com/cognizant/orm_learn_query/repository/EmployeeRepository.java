package com.cognizant.orm_learn_query.repository;

import com.cognizant.orm_learn_query.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	@Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :deptId")
	Double getAverageSalaryByDepartment(@Param("deptId") int deptId);


    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2)")
    List<Employee> getHighestPaidEmployees();

}
