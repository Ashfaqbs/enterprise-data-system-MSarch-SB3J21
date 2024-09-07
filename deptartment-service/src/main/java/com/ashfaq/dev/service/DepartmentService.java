package com.ashfaq.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashfaq.dev.entity.Department;
import com.ashfaq.dev.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long id) {
		return departmentRepository.findById(id).get();
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public void deleteDepartmentById(Long id) {
		departmentRepository.deleteById(id);
	}

	public Department updateDepartment(Department department, Long id) {
		Department department2 = departmentRepository.findById(id).get();
		department2.setDeptName(department.getDeptName());
		department2.setDescription(department.getDescription());
		department2.setCode(department.getCode());
		departmentRepository.save(department2);
		return department2;
	}

	public Department findByCode(String code) {
		Optional<Department> DeptBycode = departmentRepository.findByCode(code);
		if (DeptBycode.isPresent()) {
			return DeptBycode.get();
		} else {
			throw new RuntimeException("Department not found");
		}
	}

}
