package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employeeList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(List<Employee> employeeList) { this.employeeList = employeeList; }
}
