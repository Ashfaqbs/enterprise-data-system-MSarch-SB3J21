package com.ashfaq.dev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashfaq.dev.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<Department> findByCode(String code);

}
