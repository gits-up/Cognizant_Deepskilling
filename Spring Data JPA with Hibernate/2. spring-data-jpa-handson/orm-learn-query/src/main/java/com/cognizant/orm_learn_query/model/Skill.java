package com.cognizant.orm_learn_query.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private int id;

    @Column(name = "skill_name")
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private List<Employee> employeeList;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(List<Employee> employeeList) { this.employeeList = employeeList; }

    @Override
    public String toString() {
        return "Skill [id=" + id + ", name=" + name + "]";
    }
}
