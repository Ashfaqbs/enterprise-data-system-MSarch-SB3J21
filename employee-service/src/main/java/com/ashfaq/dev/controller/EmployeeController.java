package com.ashfaq.dev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashfaq.dev.entity.ApiResponseDTO;
import com.ashfaq.dev.entity.Employee;
import com.ashfaq.dev.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

@Autowired
private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	
	@GetMapping("/{id}")
	public ApiResponseDTO getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping()
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PostMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		return employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
	}
}
