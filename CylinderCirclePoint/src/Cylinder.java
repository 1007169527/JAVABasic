//P312

public class Cylinder extends Circle {
	private double height;
	
	public Cylinder() {
		 
	}
	
	public Cylinder(int x,int y,double radius,double height) {
		super(x,y,radius);
		setHeight(height);
	}
	
	public void setHeight(double height) {
		this.height = (height < 0.0 ? 0:height);
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		return 2*super.getArea() + super.getCircumference() * getHeight();
	}
	
	public double getVolume() {
		return super.getArea() * getHeight();
	}
	
	public String toString() {
		return super.toString() + "; Height = " + getHeight();
	}
}
	
	
	
