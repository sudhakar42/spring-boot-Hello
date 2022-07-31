package com.spring.boot.java8;



import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SystemPropertyUtils;

@SpringBootApplication
public class SpringJAVA8 {

	public static void main(String[] args) {
		SpringApplication.run(SpringJAVA8.class, args);
		collectLastNames();
	}
	
	
	public static List<String> collectLastNames() {
		System.out.println("Entered this Method....");
		
		
		List<Employee> users = Arrays.asList(
                new Employee("Ramesh", "Kumar"), 
                new Employee("Aman", "Mittal"),
                new Employee("Durgesh", "Kumar"),
                new Employee("Sriram", "Agrahari")
              );
		System.out.println(users.toString());
		Collections.sort(users, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getlName().compareTo(o2.getlName());				
			}
		});
		System.out.println(users.toString());
		
		
		Collections.sort(users, (u1, u2 ) -> u1.getfName().compareTo(u2.getfName()));
		
		System.out.println(users.toString());
		
		//print(users, u -> true);
		
	
		//List<String> lNameList=users.stream().collect(p->p.getLName);
		
		//List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		//List<String> filtered = list.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
				
		//List<String> noEMptyLst=list.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
		//System.out.println(noEMptyLst);
		
		//List<String> lNameLst=users.stream().filter(user-> user.getlName()).collect(Collectors.toList());
		
		return null;
		
	}


	private static void print(List<Employee> users, Object object) {
		// TODO Auto-generated method stub
		
	}

}
