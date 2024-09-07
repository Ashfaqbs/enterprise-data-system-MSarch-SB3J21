package com.ashfaq.dev.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ashfaq.dev.entity.Department;

//@FeignClient(url = "http://localhost:8080",value = "Department-service")//providing the base urls of the service and defining the name
//feign client library will dynamically create an implementation class for this interface

//Above we cannot have loadbalane on the department service as only on service url is passed as a parameter
//to load balance we can pass the service name it self and the api call will
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {

	@GetMapping("/api/departments/code/{code}")
	 Department getDepartmentByCode(@PathVariable String code);
	
}
