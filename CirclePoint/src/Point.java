//P305
public class Point {
	protected int x;
	protected int y;
	
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
	
	public String toString() {
		return "[" + x + ", " + y + "]"; 
	}
} 
