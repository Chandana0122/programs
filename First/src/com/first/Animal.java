package com.first;

public class Animal {
	public void sound() {
		System.out.println("Animal sound are");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a = new Animal();
		a.sound();
		
		Bird b = new Bird();
		b.sound();
		
		Cat c = new Cat();
		c.sound();

	}

	
}
