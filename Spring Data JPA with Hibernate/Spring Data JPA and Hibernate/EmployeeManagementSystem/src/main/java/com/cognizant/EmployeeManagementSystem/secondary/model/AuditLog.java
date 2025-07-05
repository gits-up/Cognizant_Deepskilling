package com.cognizant.EmployeeManagementSystem.secondary.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "audit_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String details;
}
