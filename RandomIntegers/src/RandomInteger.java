
//P171
import javax.swing.JOptionPane;

public class RandomInteger {
	public static void main(String args[]) {
		int value;
		String output = "";
		for (int counter = 1; counter <= 20; counter++) {
			value = 1 + (int) (Math.random() * 6);
			output += value + " ";
			if (counter % 5 == 0)
				output += "\n";
		}
		JOptionPane.showMessageDialog(null, output, "Random Test", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
