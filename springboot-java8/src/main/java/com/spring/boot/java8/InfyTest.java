package com.spring.boot.java8;

public class InfyTest {

	public static void main(String[] args) {
		int x=10;
		int y=5;
		
		
		x=x+y;
		y=x-y;
		x=x-y;
		
		System.out.println("X="+ x + "  Y="+ y);
		
		x=10; y=5;
		x=x*y;
		y=x/y;
		x=x/y;
		
		System.out.println("X="+ x + "  Y="+ y);
		
		System.out.println(exceptionTest());
	}

	public static int exceptionTest() {
		int i = 6;
		try {
			i = 50;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
			return i;
		}
	}
}