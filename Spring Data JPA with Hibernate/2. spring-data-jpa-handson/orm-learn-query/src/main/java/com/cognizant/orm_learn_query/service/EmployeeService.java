package com.cognizant.orm_learn_query.service;

import java.util.List;

import com.cognizant.orm_learn_query.model.Employee;
import com.cognizant.orm_learn_query.model.Skill;
import com.cognizant.orm_learn_query.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void printAllEmployeesWithSkills() {
        List<Employee> employees = employeeRepository.findAll();

        for (Employee emp : employees) {
            LOGGER.debug("Employee: {}", emp.getName());

            List<Skill> skills = emp.getSkillList();
            if (skills.isEmpty()) {
                LOGGER.debug("  Skills: None");
            } else {
                skills.forEach(skill -> LOGGER.debug("  Skill: {}", skill.getName()));
            }
        }
    }
}
