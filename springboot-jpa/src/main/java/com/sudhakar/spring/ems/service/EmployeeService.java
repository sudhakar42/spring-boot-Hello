package com.sudhakar.spring.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhakar.spring.ems.exception.ResourceNotFoundException;
import com.sudhakar.spring.ems.model.Employee;
import com.sudhakar.spring.ems.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;

	public List<Employee> findAll() {		
		return empRepo.findAll();
	}

	public Employee save(Employee emp) {
		Employee employee= empRepo.save(emp);	
		//return empRepo.findAll();
		return employee;
	}

	public Employee findEmpById(Long id) {
		Employee emp=empRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Resource Not Found Exception for the Id" + id));
		return emp;
	}

	public Employee updateEmployee(Employee empToUpdate, Long id) {
		
	/*	Optional<Employee> emp=empRepo.findById(id);
		if( emp.empty().) {
			
		}*/
		
		Employee emp=empRepo.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Resource Not Found Exception for the Id" + id));
		empToUpdate.setId(id);
		/*emp.setFirstName(empToUpdate.getFirstName());
		emp.setLastName(empToUpdate.getLastName());
		emp.setEmailId(empToUpdate.getEmailId());*/
		
		return empRepo.save(empToUpdate);
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		empRepo.deleteById(id);
	}
}
