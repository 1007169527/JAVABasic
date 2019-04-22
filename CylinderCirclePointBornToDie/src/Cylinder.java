//P315
public class Cylinder extends Circle {
	private double height;
	
	public Cylinder() {
		System.out.println("Cylinder no-argument constructor: " + this);
	}
	
	public Cylinder(int x,int y, double r, double h) {
		super(x,y,h);
		System.out.println("Cylinder constructor: " + this);
		/*。。。*/
	}
	
	protected void finalize() {
		super.finalize();
		System.out.println("Cylinder finalize: " + this);
	}
	
	/*。。。*/
}
