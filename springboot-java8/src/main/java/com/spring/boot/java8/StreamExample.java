package com.spring.boot.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
	public static void main(String[] args) {		
		List<Employee> userList = Arrays.asList(
                new Employee("Ramesh", "Kumar", 30000, "B"), 
                new Employee("Aman", "Mittal", 10000 , "A"),
                new Employee("Durgesh", "Kumar", 50000, "C"),
                new Employee("Sriram", "Agrahari", 70000, "A")
              );	
		//Apply Filter on a list   //**************************FILTER by salary> 10000
		List<Employee> usersSalGT30K = userList.stream()
				.filter((user) -> user.getSalary() > 30000).collect(Collectors.toList()); 
		//usersSalGT30K.forEach(System.out::println);
				 
		
		//Apply Sorting on a list
		List<Employee> usersSalSorted =  userList.stream().
				sorted((Employee o1, Employee o2) -> (o1.getSalary() - o2.getSalary())).collect(Collectors.toList());		
		usersSalSorted.forEach((System.out::println));
		
		//List<User> usersSalSortedComparator =  u
				userList.stream().
				sorted(Comparator.comparingInt(Employee::getSalary)).collect(Collectors.toList()).forEach(System.out::println);
				
	
		List<Employee> usersSalSortedComparatorRev =  userList.stream().
				sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());	
		
		
		System.out.println(usersSalSortedComparatorRev);
		
		//Apply MAP on a function		********************MAP - traverse all list elements and 
		List<String> lastNames= userList.stream()
				.map(Employee:: getlName).collect(Collectors.toList());
		System.out.println(lastNames);
		
		//Apply REDUCE on a function		********************MAP - traverse all list elements and
				//userList.stream()
		          //      .reduce( (u1, u2) -> u1.getSalary() + u1.getSalary())
		//System.out.println(result);
		
		
		
		
		
		
		
		
		
		
		
		
		List<Employee> usersSalSortedCompator =  userList.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return (o1.getSalary() - o2.getSalary());
			}
			
		}).collect(Collectors.toList());
	//	usersSalSortedCompator.forEach((System.out::println));
	}
	
	
	
	
public StreamExample() {		
	}


}
