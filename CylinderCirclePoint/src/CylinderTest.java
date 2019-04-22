import javax.swing.JOptionPane;

//P313

public class CylinderTest {
	public static void main(String args[]) {
		Cylinder cylinder = new Cylinder(12, 23, 2.5,5.7);
		String output = "At the first time X = " + cylinder.getX() + " Y = " + cylinder.getY() + " R = " + cylinder.getRadius() + " H = " + cylinder.getHeight();
		cylinder.setHeight(10);
		cylinder.setRadius(10);
		output += "\nAt the second time X = " + cylinder.getX() + " Y = " + cylinder.getY() + " R = " + cylinder.getRadius() + " H = " + cylinder.getHeight();
		output += "\nArea = " + cylinder.getArea() +  "\nVolume = " + cylinder.getVolume();
		JOptionPane.showMessageDialog(null, output);
		System.exit(0);
	}
}
