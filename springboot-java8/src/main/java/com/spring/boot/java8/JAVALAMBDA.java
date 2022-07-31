package com.spring.boot.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.SystemPropertyUtils;

import com.spring.boot.java8.inerfaces.Foo;

//@SpringBootApplication
public class JAVALAMBDA {

	public static void main(String[] args) {
		SpringApplication.run(JAVALAMBDA.class, args);
		collectLastNames();
	}
	
	
	public static void collectLastNames() {
		
		
		Foo foo= () -> System.out.print("HELLO................");
		foo.foo();
		
	}
	
	
}


