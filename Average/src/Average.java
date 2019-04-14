
//P99
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Average {
	public static void main(String args[]) {
		int total;
		int gradeCounter;
		int grade;
		double average;
		String gradeString;
		total = 0;
		gradeCounter = 0;
		while (true) {
			gradeString = JOptionPane.showInputDialog("Enter integer grade, or -1 to Quit");
			grade = Integer.parseInt(gradeString);
			if (grade == -1)
				break;
			total = total + grade;
			gradeCounter = gradeCounter + 1;
		}
		average = (double) total / gradeCounter;
		DecimalFormat twoDigits = new DecimalFormat("0.00");
		JOptionPane.showMessageDialog(null, "Class average is " + twoDigits.format(average), "Class Average",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
