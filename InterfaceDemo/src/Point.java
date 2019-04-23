//P343
public class Point extends Object implements Shape {
	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
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

	public double getArea() {
		return 0;
	}

	public double getVolume() {
		return 0;
	}

	public String getName() {
		return "Point";
	}

	public String toString() {
		return "[" + x + ", " + y + "]";
	}
}
