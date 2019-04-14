import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JOptionPane;
public class AddtionApplet extends JApplet {
	
	double sum;
	
	public void init() {
		String firstNumber;
		String secondNumber;
		double number1;
		double number2;
		
		
		firstNumber = JOptionPane.showInputDialog("Enter the first float-value");
		secondNumber = JOptionPane.showInputDialog("Enter the second float-value");
		
		number1 = Double.parseDouble(firstNumber);
		number2 = Double.parseDouble(secondNumber);

		sum = 0;
		
		sum = number1 + number2;
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(15, 10, 270, 20);
		g.drawString("The sum is " + sum,25,25);
	}
}
