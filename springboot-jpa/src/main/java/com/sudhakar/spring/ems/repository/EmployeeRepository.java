package com.sudhakar.spring.ems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sudhakar.spring.ems.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//@Query(name="", nativeQuery=false)
	//public default Employee getUserByStatus(String id) 	}
}
