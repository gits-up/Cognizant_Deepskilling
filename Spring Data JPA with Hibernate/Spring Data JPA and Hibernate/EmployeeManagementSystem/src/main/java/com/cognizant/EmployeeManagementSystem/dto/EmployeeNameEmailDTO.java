package com.cognizant.EmployeeManagementSystem.dto;

import org.springframework.beans.factory.annotation.Value;

public class EmployeeNameEmailDTO {

    private String customName;
    private String customEmail;

    public EmployeeNameEmailDTO(
            @Value("#{target.name + ' (Employee)'}") String name,
            @Value("#{target.email + ' <Email>'}") String email) {
        this.customName = name;
        this.customEmail = email;
    }

    public String getCustomName() {
        return customName;
    }

    public String getCustomEmail() {
        return customEmail;
    }
}
