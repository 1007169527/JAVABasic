
//P109
import javax.swing.JOptionPane;

public class Analysis {
	public static void main(String argsp[]) {
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;
		int result;
		String input;
		String output;
		while (true) {
			input = JOptionPane.showInputDialog("Enter result 1 for pass 2 for fail -1 to stop");
			result = Integer.parseInt(input);
			if (result == -1)
				break;
			else if (result == 1)
				++passes;
			else if (result == 2)
				++failures;
			else
				continue;
			++studentCounter;
		}
		output = "Passed: " + passes + " Failed: " + failures + " rate: " + passes * 100 / studentCounter + "%";
		if (passes > 8)
			output = output + "\nRaise Tuition";
		JOptionPane.showMessageDialog(null, output, "Analysis Results", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
