
//P45
import javax.swing.JOptionPane;

public class Comparsion {
	public static void main(String argsp[]) {
		String firstNumber;
		String secondNumber;
		int number1;
		int number2;
		String result;
		firstNumber = JOptionPane.showInputDialog("Enter the first integer");
		secondNumber = JOptionPane.showInputDialog("Enter the second integer");
		number1 = Integer.parseInt(firstNumber);
		number2 = Integer.parseInt(secondNumber);
		result = "";
		if (number1 == number2)
			result = "result " + number1 + " == " + number2;
		if (number1 != number2)
			result = "result " + number1 + " != " + number2;
		if (number1 > number2)
			result = result + "\n" + "result " + number1 + " > " + number2;
		if (number1 < number2)
			result = result + "\n" + "result " + number1 + " < " + number2;
		JOptionPane.showMessageDialog(null, result, "Comparsion Results", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
