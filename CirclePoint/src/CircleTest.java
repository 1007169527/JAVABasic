//P307
import javax.swing.JOptionPane;

public class CircleTest {
	public static void main(String args[]) {
		Circle circle = new Circle(10,10,5);
		String output = "X = " + circle.getX() + " Y  = " + circle.getY() + " R = " + circle.getRadius();
		circle.setX(20);
		circle.setY(20);
		circle.setRadius(10);
		output += "\nThe new circle param is: " + circle.toString();
		output += "\nThe circumference of the new circle is: " + circle.getCircumference();
		output += "\nThe Area of the new circle is: " + circle.getArea();
		JOptionPane.showMessageDialog(null, output);
	}
}
