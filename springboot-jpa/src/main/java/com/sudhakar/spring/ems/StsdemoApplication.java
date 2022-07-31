package com.sudhakar.spring.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.sudhakar.spring.ems"})
public class StsdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StsdemoApplication.class, args);
	}

}
