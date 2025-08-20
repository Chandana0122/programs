package com.first;


public class Java {
	//default constructor
	Java() {
		System.out.println("Welcome to constructor overloading");
		
	}
	
	//parameterized
	Java(int a, int b) {
		System.out.println(a+b);
	}
	
	Java(String s, int x) {
		System.out.println("My name is " + s + " age is " + x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Java j1 = new Java();
		Java j2 = new Java(10,20);
		Java j3 = new Java("chandana" , 22);
		
	}

}
