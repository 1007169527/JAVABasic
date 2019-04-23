//P330
public class Point extends Shape {
	private int x;
	private int y;
	
	public Point() {
		// implicit call to Object constructor occurs here
	}
	
	public Point(int x,int y) {
		// implicit call to Object constructor occurs here
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x= x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String getName() {
		return "Point";
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]"; 
	}
 } 
