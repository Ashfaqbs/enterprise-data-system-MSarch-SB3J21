package com.ashfaq.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashfaq.dev.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
