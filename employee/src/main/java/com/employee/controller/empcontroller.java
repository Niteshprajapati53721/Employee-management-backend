package com.employee.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.employee;


import com.employee.service.empservice;

@RestController
@CrossOrigin("*")
public class empcontroller {
	
	@Autowired
	empservice service;
	
	
	
	@GetMapping("/getemployee")
	
	public List<employee> getemployee()
	{
		return service.getemployee();
	}

	@PostMapping("/addemployee")
	public employee addemployee( @RequestBody employee employee)
	{
		return service.addemployee(employee);
	}
	@GetMapping("getempbyid/{id}")
	public employee getempbyid(@PathVariable("id") int id)
	{
		return service.getempbyid(id);
	}
	@PutMapping("update/{id}")
	public ResponseEntity< employee> updateemployee(@PathVariable("id")int id,@RequestBody employee employee)
	{
		
		
		return service.updateemployee(id,employee);
		
	}
	
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteemployee(@PathVariable("id") int id)
	{
		return service.deleteemployee(id);
		
	}
	@GetMapping("findbycity/{city}")
	public List<employee> findbyname(@PathVariable("city")String city){
		return service.findBycity(city);
		
	}
	
	/*userurl="http://localhost:8080/saveuser"
saveuser( user:User):Observable<object>{
return this.httpst.post(`${this.userurl}`,user)
this.service.saveuser(this.user).subscribe(data =>{*/
}

