//P344

public class InterfaceTest {
	public static void main(String args[]) {
		Point point = new Point(10, 10);
		String output = point.getName() + ": " + point;
		System.out.println(output);
		output = point.getName() + ": " + point.toString();
		System.out.println(output);
	}
}
