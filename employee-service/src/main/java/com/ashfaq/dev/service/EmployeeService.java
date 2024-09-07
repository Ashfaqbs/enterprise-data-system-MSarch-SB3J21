package com.ashfaq.dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.ashfaq.dev.entity.ApiResponseDTO;
import com.ashfaq.dev.entity.Department;
import com.ashfaq.dev.entity.Employee;
import com.ashfaq.dev.repository.EmployeeRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepository;

//	1
//	@Autowired
//	private RestTemplate restTemplate;

//2
//	@Autowired
//	private WebClient webClient ;

	// 3
	@Autowired
	private APIClient apiClient;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

//	@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
	public ApiResponseDTO getEmployeeById(long id) {

		Employee employee = employeeRepository.findById(id).get();

		log.info("Employee details: " + employee);

//		Rest template
//		ResponseEntity<Department> resoponseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/code/"+employee.getDepartmentCode() ,Department.class);
//		Department department = resoponseEntity.getBody();
//		log.info("Department details: "+department);

//		web client

//		ResponseSpec responseSpec = webClient
//		.get()
//		.uri("http://localhost:8080/api/departments/code/"+employee.getDepartmentCode())
//		.retrieve();
//		
//		
//		Department department = responseSpec.bodyToMono(Department.class)
//				.block();//synchronous call

//open clients

		Department department = apiClient.getDepartmentByCode(employee.getDepartmentCode());

		log.info("Department details: " + department);
		ApiResponseDTO apiResponseDTO = ApiResponseDTO.builder().department(department).employee(employee).build();

		log.info("apiResponseDTO: " + apiResponseDTO);
		return apiResponseDTO;

	}

	public Employee updateEmployee(Employee employee, long id) {
		Employee employee2 = employeeRepository.findById(id).get();
		employee2.setFirstname(employee.getFirstname());
		employee2.setLastname(employee.getLastname());
		employee2.setEmail(employee.getEmail());
		employee2.setDepartmentCode(employee.getDepartmentCode());
		employeeRepository.save(employee2);
		return employee2;
	}

	public void deleteEmployee(long id) {
		employeeRepository.deleteById(id);
	}

	public ApiResponseDTO getDefaultDepartment(long id, Exception e) {

		Employee employee = employeeRepository.findById(id).get();

		log.info("Employee details: " + employee);

		Department department = new Department();
		department.setDeptName("Default Deptament");
		department.setDescription("Default Description");
		department.setCode("DEFAULT CODE");
		department.setId(1);

		log.info(" Default Department details: " + department);

		ApiResponseDTO apiResponseDTO = ApiResponseDTO.builder().department(department).employee(employee).build();

		log.info("apiResponseDTO: " + apiResponseDTO);
		return apiResponseDTO;

	}

}
