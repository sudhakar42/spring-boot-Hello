package com.spring.boot.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {
	static  public  void main(String[] args) {
		
		Stream<Employee> userList = Stream.of(
                new Employee("Ramesh", "Kumar", 30000, "B", Arrays.asList("222-321-2345", "870-321-0000") ), 
                new Employee("Aman", "Mittal", 10000 , "A", Arrays.asList("111-321-2345", "111-321-0000") ),
                new Employee("Durgesh", "Shetty", 50000, "C", Arrays.asList("333-321-2345", "333-321-0000") ),
                new Employee("Sriram", "Agrahari", 70000, "A", Arrays.asList("999-321-2345", "999-321-0000") ),
                new Employee("Sudhakar", "Rao", 120000, "A", Arrays.asList("444-321-2345", "444-321-0000") )
                
              );	
		 List<Employee> empList=userList.collect(Collectors.toList());
// EXAMPLE SUPPLIER EXAMPLE - > Supplier.get		 
		 Employee firstEmp=empList.stream().findFirst().get();
		 System.out.println(firstEmp);
		 System.out.println("********************");
		 
		 //FILTER Example: if else condition - which internally uses Predicate->test();
		 List<Employee> filteredList=empList.stream()
				 .filter(emp->emp.getSalary()>30000).collect(Collectors.toList());
		 
		 Stream<Employee> streamList=empList.stream()
				 .filter(emp->emp.getSalary()>30000);
		 filteredList.forEach(System.out::println);
		 
		 System.out.println("********************");
//SORT EXAMPLE 1 - LIST 
		 List<Employee> sortedBySalList=empList.stream()
				 .sorted( (e1, e2) -> e1.getSalary()-e2.getSalary()).collect(Collectors.toList());
		 sortedBySalList.forEach(System.out::println);
		 System.out.println("********************");
		
//SORT EXAMPLE 2 - ASCENDING Using COMPARATOR - LIST 
		 List<Employee> sortedBySalListComparator=empList.stream()
				 .sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		 sortedBySalListComparator.forEach(System.out::println);
		 System.out.println("---------------------------------------");
		 
//SORT EXAMPLE 3 - Sort by 2 firlds - ASCENDING Using COMPARATOR - LIST 
		 List<Employee> sortedBy2ColsComparator=empList.stream()
				 .sorted(Comparator.comparing(Employee::getSalary))
				 .sorted(Comparator.comparing(Employee::getGrade)).collect(Collectors.toList());
		 sortedBy2ColsComparator.forEach(System.out::println);
		 System.out.println("========================================");
//REVERSE SORT EXAMPLE 3 - DESCENDING  Using COMPARATOR - SORT LIST 
		 List<Employee> sortedBySalReverseOrder=empList.stream()
				 .sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());				 
		 sortedBySalReverseOrder.forEach(System.out::println);		 
		 
//MAP is used for data transformations
		 //Collect all last names of all employees
		 List<String> lNames=empList.stream().map(Employee::getlName).collect(Collectors.toList());
		 System.out.println("========================================");
		 lNames.forEach(System.out::println);
		
 //Collect all last names of all employees
		 List<String> phoneNumbers=empList.stream().flatMap(emp-> emp.getPhoneNumbers().stream()).collect(Collectors.toList());
		 System.out.println("========================================");
		 phoneNumbers.forEach(System.out::println);
		 
// OPTIONALs are used to avoid Null Pointer Exceptions in the code
		 String str1="abc@gmail.com";
		 String str2=null;
		 Optional<String> str=Optional.empty();               //Optional.empty();
		 //System.out.println("Str ---->  "+ str.get());
		 System.out.println("========================================"); 
		 Optional<String> str4=Optional.of(str1);             //Optional.of
		 System.out.println("Str ---->  "+ str4.get());
		 
		 System.out.println("========================================"); 
		 Optional<String> optionalVal3=Optional.ofNullable(str2);            //Optional.ofNullable
		 if(optionalVal3.isPresent()) {
			 System.out.println("Str ---->  "+ optionalVal3.get());
		 }
		 
//get MAX Salary of Grade A Employees
		 System.out.println("========================================"); 
		 Optional<Integer> maxSalaryofGradeA= empList.stream()
				         .filter(emp->emp.getGrade().equals("A"))
		                 .map(Employee::getSalary)
		                 .reduce(Integer::max );
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@========================================");
		 if(maxSalaryofGradeA.isPresent()) {
			 System.out.println("@@MAX Salaray of GRADE A " +  maxSalaryofGradeA.get());
		 }
		 
		 
//get SUM Salary of Grade A Employees
		 System.out.println("========================================"); 
		 Optional<Integer> sumSalaryofGradeA= empList.stream()
				         .filter(emp->emp.getGrade().equals("A"))
		                 .map(Employee::getSalary)
		                 .reduce(Integer::sum );
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@========================================");
		 if(sumSalaryofGradeA.isPresent()) {
			 System.out.println("@@SUM Salaray of GRADE A " +  sumSalaryofGradeA.get());
		 }
		 
//get AVERAGE Salary of Grade A Employees
		 System.out.println("========================================"); 
		 Double  avgSalaryofGradeA= empList.stream()
				         .filter(emp->emp.getGrade().equals("A"))
		                 .map(Employee::getSalary)
		                 .mapToInt(i->i)
		                 .average()
		                 .getAsDouble();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@========================================");
		 if(sumSalaryofGradeA.isPresent()) {
			 System.out.println("@@SUM Salaray of GRADE A " +  avgSalaryofGradeA);
		 }
		 		 
		 
//get SUM Salary of Grade A Employees
		 System.out.println("========================================"); 
		 double sumSalaryofGradeA_v2= empList.stream()
				         .filter(emp->emp.getGrade().equals("A"))
		                 .map(Employee::getSalary)
		                 .mapToDouble(i->i)
		                 .sum();
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@========================================");
		 System.out.println("@@MAX Salaray of GRADE A " +  sumSalaryofGradeA_v2);
		 
		/* int a=128;
		 byte b= (byte) (a);		 
		 System.out.println(b);*/
		 
//GROUP BY EMPLOYEE GRADE		 
		 Map<String, List<Employee>> map=empList.stream().collect(Collectors.groupingBy(Employee:: getGrade));
		 map.entrySet().forEach(entry-> System.out.println(entry.getKey() + "-"+entry.getValue()));
		 
		 //empList.stream().
		 Map<String, Long> countGropByGrade=empList.stream()
				 .collect(Collectors.groupingBy(Employee:: getGrade, Collectors.counting()));
		 countGropByGrade.entrySet().forEach(entry-> System.out.println(entry.getKey() + "-"+entry.getValue()));
		 
		 
		 SortedMap<String, String> map122 =new TreeMap();
		// SortedMap<String, Map<String, String> map123 =new TreeMap();
		 
	}	
}
