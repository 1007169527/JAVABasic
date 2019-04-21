//P305
public class Circle extends Point {
	private double radius;
	
	public Circle() {
		
	}
	
	public Circle(int x,int y, double radius) {
		this.x = x;
		this.y = y;
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
		return "Center = [" +x+", "+y+"]; radius = " + radius;
	}
}
