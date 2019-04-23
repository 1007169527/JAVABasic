//323
public class CircleTest {
	public static void main(String args[]) {
		Circle circle = new Circle(10,10,5);
		Point point = new Point(10,20);
		System.out.println("Circle: " + circle.toString());
		System.out.println("Point: " + point.toString());
		Point point1 = circle;
		System.out.println("After process Point point1 = circle;");
		System.out.println("Call circle's to String with superclass point1: " + point1.toString());
		//It will cause compile error when process point1.getRadius();
	}
}
