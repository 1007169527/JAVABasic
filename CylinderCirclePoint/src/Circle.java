//P305
public class Circle extends Point {
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(int x,int y, double radius) {
		super(x,y);
		setRadius(radius);
	}
	
	public void setRadius(double radius) {
		this.radius = ((radius < 0.0) ? 0.0:radius);
	}
	
	public double getRadius() {
		return radius;
	}
	
	public double getDiameter() {
		return 2* radius;
	}
	
	public double getCircumference() {
		return Math.PI * getDiameter();
	}
	
	public double getArea() {
		return radius * getCircumference() /2;
	}
	
	public String toString() {
		return super.toString() + " radius = " + radius;
	}
}
