package inheritance;

	class A {
		public void add(int a, int b) {
			System.out.println("Addition: " + (a + b));
		}
		
		public void sub(int a, int b) {
			System.out.println("subtraction: " + (a - b));
		}
		
		public void multiply(int a, int b) {
			System.out.println("multiplcation: " + (a * b));
		}
		
		
		public void divide(int a, int b) {
			System.out.println("division: " + (b/a));
		}
	}
	
	class B extends A {
		void andOperation(int x, int y, int z) {
	        System.out.println(x>y && x > z);
	    }

	    void or(int x, int y, int z) {
	        System.out.println(x>y || x>z);
	    }    
		
	}
	public class Single {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b = new B();
		b.add(10, 20);
		b.sub(20, 10);
		b.multiply(10,30);
		b.divide(20, 10);
		b.andOperation(10, 20, 30);
		b.or(10, 20, 30);
		
	}

}
