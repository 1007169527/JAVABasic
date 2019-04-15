
//P223
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BinarySearch extends JApplet implements ActionListener {
	JLabel enterLabel, resultLabel;
	JTextField enterField, resultField;
	JTextArea output;
	int array[];
	String display = "";

	public void init() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		enterLabel = new JLabel("Enter integer search key");
		container.add(enterLabel);
		enterField = new JTextField(10); // -1 = length of JTextField
		container.add(enterField);
		enterField.addActionListener(this);
		resultLabel = new JLabel("result: ");
		container.add(resultLabel);
		resultField = new JTextField(20);
		resultField.setEditable(false);
		container.add(resultField);
		output = new JTextArea(6, 60);
		output.setFont(new Font("Monospaced", Font.PLAIN, 12));
		container.add(output);
		array = new int[15];
		for (int counter = 0; counter < array.length; counter++)
			array[counter] = counter * 2;
	}

	public int binarySearch(int array[], int key) {
		int low = 0;
		int high = array.length;
		int middle;
		while (low <= high) {
			middle = (low + high) / 2;
			buildOutput(array, low, middle, high);
			if (key == array[middle])
				return middle;
			else if (key < array[middle])
				high = middle - 1;
			else if (key > array[middle])
				low = middle + 1;
		}
		return -1;
	}

	public void buildOutput(int arrayp[], int low, int middle, int high) {
		DecimalFormat twoDigits = new DecimalFormat("00");
		for (int counter = 0; counter < array.length; counter++) {
			if (counter < low || counter > high)
				display += "   ";
			else if (counter == middle)
				display += twoDigits.format(array[counter]) + "*";
			else
				display += twoDigits.format(array[counter]) + " ";
		}
		display += "\n";
	}

	public void actionPerformed(ActionEvent actionEvent) {
		String searchKey = actionEvent.getActionCommand();
		int element = binarySearch(array, Integer.parseInt(searchKey));
		output.setText(display);
		if (element != -1)
			resultField.setText("Found value in element " + element);
		else
			resultField.setText("Value not found");
	}
}
