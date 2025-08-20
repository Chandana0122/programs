package encapsulation;

public class Triangle implements Shape{
	private double base;
	private double height;
	
	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return 0.5 * base * height;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle(10.00,20);
		Circle c1 = new Circle(20.00);
		Triangle t1 = new Triangle(4,9);
		
		System.out.println(r1.getArea());
		System.out.println(c1.getArea());
		System.out.println(t1.getArea());
	}

}
