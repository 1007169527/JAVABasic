
//P556
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DivideTest extends JFrame implements ActionListener {
	private JTextField inputField1, inputField2, outputField;
	int num1, num2, result;

	public DivideTest() {
		// TODO Auto-generated constructor stub
		super("Testing Divide");
		Container container = getContentPane();
		container.setLayout(new GridLayout(3, 2));
		container.add(new JLabel("Enter numerator", SwingConstants.RIGHT));
		inputField1 = new JTextField();
		container.add(inputField1);
		container.add(new JLabel("Enter denominator and press Enter", SwingConstants.RIGHT));
		inputField2 = new JTextField();
		container.add(inputField2);
		inputField2.addActionListener(this);

		container.add(new JLabel("Result", SwingConstants.RIGHT));
		outputField = new JTextField();
		container.add(outputField);

		setSize(525, 100);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		outputField.setText("");

		try {
			num1 = Integer.parseInt(inputField1.getText());
			num2 = Integer.parseInt(inputField2.getText());
			result = quotient(num1, num2);
			outputField.setText(String.valueOf(result));
		} catch (NumberFormatException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "You must enter two integers", "Invalid Number Format",
					JOptionPane.ERROR_MESSAGE);
		} catch (ArithmeticException e2) {
			// TODO: handle exception
			JOptionPane.showConfirmDialog(this, e2.toString(), "Arithetic Exception", JOptionPane.ERROR_MESSAGE);
		}
	}

	private int quotient(int numerator, int denominator) throws ArithmeticException {
		return numerator / denominator;
	}

	public static void main(String[] args) {
		DivideTest divideTest = new DivideTest();
		divideTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
