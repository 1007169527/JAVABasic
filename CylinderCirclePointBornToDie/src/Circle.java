//P315
public class Circle extends Point {
	private double radius;
	
	public Circle() {
		System.out.println("Circle no-argument constructor: " + this);
	}
	
	public Circle(int x,int y,double r) {
		super(x,y);
		System.out.println("Circle constructor: " + this);
		/*¡£¡£¡£*/
	}
	
	protected void finalize() {
		super.finalize();
		System.out.println("Circle finalize: " + this);
	}
	
	/*...*/
}
