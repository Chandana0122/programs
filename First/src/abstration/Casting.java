package abstration;

class Parent {
	public void name() {
		
		System.out.println("parent class");
	}
}

class Child extends Parent {
	public void name1() {
		System.out.println("child class");
	}
}

public class Casting {
	public static void main(String[] args) {
		Child cl = new Child();
		cl.name1();
		cl.name();
		
		Parent p1 = new Child(); //upcasting
		((Child) p1).name1(); 
		p1.name();
		
		//Child c2 = (Child) new Parent(); //downcasting not possible
		
		Parent p2 = new Parent();
		p2.name();
		//p2.name1(); //only parent class can be called
		
		
	}

}
