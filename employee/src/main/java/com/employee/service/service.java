package com.employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.emprepository.employeerepo;
import com.employee.model.employee;

@Service
public class service  implements empservice{
	
	@Autowired
	employeerepo repo;

	@Override
	public List<employee> getemployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public employee addemployee(employee employee) {
		
		return repo.save(employee);
	}

	@Override
	public employee getempbyid(int id) {
		employee employee;
		if(repo.findById(id).isPresent()==false)
		{
			return null;
		}
		else
		{
			employee=repo.findById(id).get();
			return employee;
		}
	}

	@Override
	public ResponseEntity<employee> updateemployee(int id, employee employee) {
		employee emp;
		if(repo.findById(id).isPresent()==false)
		{
			return null;
		}
		else {
			
			emp=repo.findById(id).get();
			emp.setId(employee.getId());
			emp.setFirstname(employee.getFirstname());
			emp.setLastname(employee.getLastname());
			emp.setCity(employee.getCity());
			emp.setEmail(employee.getEmail());
			employee updatedemployee=repo.save(emp);
					return  ResponseEntity.status(HttpStatus.OK).body(updatedemployee);
		}
		
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteemployee(int id) {
	if(repo.findById(id).isPresent()==false)
	{
		return null;
	}
	else
	{
		repo.deleteById(id);
		Map<String,Boolean> response=new HashMap<String, Boolean>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	}

	@Override
	public List<employee> findBycity(String city) {
		
		return repo.findBycity(city);
	}

	

	
}
