package com.cognizant.EmployeeManagementSystem.secondary.repository;

import com.cognizant.EmployeeManagementSystem.secondary.model.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}
