import javax.swing.JOptionPane;

public class Addtion {
	public static void main(String args[]) {
		String firstNumber;
		String secondNumber;
		int number1;
		int number2;
		int sum;
		firstNumber = JOptionPane.showInputDialog("Enter the first integer");
		secondNumber = JOptionPane.showInputDialog("Enter the second integer");
		
		number1 = Integer.parseInt(firstNumber);
		number2 = Integer.parseInt(secondNumber);
		sum = number1 + number2;
		
		JOptionPane.showMessageDialog(null, "The sum is " + sum);
		
		System.exit(0);
	}
}
