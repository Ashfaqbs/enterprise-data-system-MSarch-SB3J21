package com.ashfaq.dev.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	private long id;
	private String deptName;
	private String description;
	private String code;

	
}
