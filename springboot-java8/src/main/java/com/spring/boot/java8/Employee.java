package com.spring.boot.java8;

import java.util.List;

public class Employee {

	/**
	 * @param fName
	 * @param lName
	 * @param salary
	 * @param grade
	 */
	public Employee(String fName, String lName, int salary, String grade) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.grade = grade;
	}

	private String fName;
	private String lName;
	private int salary ;
	private String grade;
	
	/**
	 * @param fName
	 * @param lName
	 * @param salary
	 * @param grade
	 * @param phoneNumbers
	 */
	public Employee(String fName, String lName, int salary, String grade, List<String> phoneNumbers) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.grade = grade;
		this.phoneNumbers = phoneNumbers;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	List<String> phoneNumbers;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Employee(String fName, String lName, int salary) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Employee() {

	}

	public Employee(String fname, String lname) {
		// TODO Auto-generated constructor stub
		this.fName=fname;
		this.lName=lname;
	}

	@Override
	public String toString() {
		return "Employee [fName=" + fName + ", lName=" + lName + ", salary=" + salary + ", grade=" + grade + "]";
	}

	
	

}
