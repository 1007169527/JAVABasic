
//P210
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class IntArray {
	public static void main(String args[]) {
		// int array[] = new int[10];
		int array[] = { 10, 20, 30, 40 };
		String output = "Index\tValue\n";
		for (int counter = 0; counter < array.length; counter++)
			if (counter % 2 == 0)
				array[counter] = 0;
		for (int counter = 0; counter < array.length; counter++)
			output += counter + "\t" + array[counter] + "\n";
		JTextArea outputArea = new JTextArea();
		outputArea.setText(output);
		JOptionPane.showMessageDialog(null, outputArea, "Initializing an Array of int Values",
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}
