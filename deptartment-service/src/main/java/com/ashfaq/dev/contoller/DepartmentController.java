package com.ashfaq.dev.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashfaq.dev.entity.Department;
import com.ashfaq.dev.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping()
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {

		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}

	
	
	@GetMapping("/code/{code}")
	public Department getDepartmentByCode(@PathVariable String code) {
		return departmentService.findByCode(code);
	}

}
