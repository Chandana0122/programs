package abstration;

abstract class Animal {
	public abstract void sound();
}


class Lion extends Animal {
 @Override
 public void sound() {
     System.out.println("Lion roars!");
 }
}


class Tiger extends Animal {
 @Override
 public void sound() {
     System.out.println("Tiger growls!");
 }
}


public class Animaldemo {
	
	    public static void main(String[] args) {
	        
	        Lion lion = new Lion();
	        Tiger tiger = new Tiger();

	        
	        lion.sound();   
	        tiger.sound();  
	    }
	}



