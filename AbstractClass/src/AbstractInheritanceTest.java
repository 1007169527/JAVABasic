
//P333
import javax.swing.JOptionPane;

public class AbstractInheritanceTest {
	public static void main(String args[]) {
		Cylinder cylinder = new Cylinder(10, 10, 5, 5);
		Circle circle = new Circle(10, 10, 5);
		Point point = new Point(10, 10);
		String output = "cylinder.getName: " + cylinder.getName() + "\ncircle.getName: " + circle.getName()
				+ "\npoint.getName: " + point.getName();
		Shape arrayOfShape[] = new Shape[3];
		arrayOfShape[0] = point;
		arrayOfShape[1] = circle;
		arrayOfShape[2] = cylinder;
		for (int i = 0; i < arrayOfShape.length; i++) {
			output += "\n\narrayOfShape[" + i + "].getName: " + arrayOfShape[i].getName();
			output += "\narrayOfShape[" + i + "].getArea: " + arrayOfShape[i].getArea();
			output += "\narrayOfShape[" + i + "].getVolume: " + arrayOfShape[i].getVolume();
		}
		JOptionPane.showMessageDialog(null, output);
		System.exit(0);
	}
}
