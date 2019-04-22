//P315
public class Point {
	private int x;
	private int y;
	public Point() {
		System.out.println("Point no-argument constructor: " + this);
	}
	
	public Point(int x, int y) {
		System.out.println("Point constructor: " + this);
		/*...*/
	}
	
	protected void finalize() {
		System.out.println("Point finalize: " + this);
	}
	
	/* ...*/
}
