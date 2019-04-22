//P317
public class CylinderTest {
	public static void main(String args[]) {
		Point point;
		Circle circle;
		Cylinder cylinder;
		point = new Point(1,2);
		System.out.println();
		circle = new Circle(10,10,10);
		System.out.println();
		cylinder = new Cylinder(10,10,10,10);
		System.out.println();
		point = null;
		circle = null;
		cylinder = null;
		System.out.println("We have set objects to null\n");
		System.gc();
	}
}
