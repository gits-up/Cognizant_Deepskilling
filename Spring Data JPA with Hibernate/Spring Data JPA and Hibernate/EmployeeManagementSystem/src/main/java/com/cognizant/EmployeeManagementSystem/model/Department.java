package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}