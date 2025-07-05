package com.cognizant.EmployeeManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id") // Foreign key in employees table
    private Department department;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
