/**
 * 
 */
package com.sudhakar.spring.ems.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sudhakar.spring.ems.model.Employee;
import com.sudhakar.spring.ems.repository.EmployeeRepository;
import com.sudhakar.spring.ems.service.EmployeeService;

/**
 * @author psred
 *
 */

@RestController
@RequestMapping("/api/v1") //Predicate mapping
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
		
	//@Autowired
	//EmployeeRepository empRepo;

	@GetMapping("/helloWorld")
	public String helloWorld() {	
		//System.out.println("KEY****************************** " + apikey );
		return "Welcome to Rest API";
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(@RequestHeader String apikey) {	
		System.out.println("KEY****************************** " + apikey );
		return empService.findAll();
	}
	
	@GetMapping("/findEmpById/{id}")
	public Employee findEmpById(@PathVariable Long id) {	
		return empService.findEmpById(id);
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp){
		return empService.save(emp);
		//return null;
	}
	
	@PutMapping("/updateEmployee/{id}") 
	public Employee updateEmployee(@RequestBody Employee emp, @PathVariable Long id){		
		return empService.updateEmployee(emp,id);
	}
	
	@DeleteMapping("/deleteEmployee/{id}") 
	public void deleteEmployee(@PathVariable Long id){		
		empService.deleteEmployee(id);
	}
}
