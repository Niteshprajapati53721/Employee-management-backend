package com.employee.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.employee.model.employee;



public interface empservice {

	List<employee> getemployee();

	employee addemployee(employee employee);

	

	employee getempbyid(int id);

	ResponseEntity<employee> updateemployee(int id, employee employee);

	 ResponseEntity<Map<String, Boolean>> deleteemployee(int id);

	List<employee> findBycity(String city);

}
