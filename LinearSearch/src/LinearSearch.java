
//P221
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LinearSearch extends JApplet implements ActionListener {
	JLabel enterLabel, resultLabel;
	JTextField enterField, resultField;
	int array[];

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
		array = new int[100];
		for (int counter = 0; counter < array.length; counter++)
			array[counter] = counter * 2;
	}

	public int linearSearch(int array[], int key) {
		for (int counter = 0; counter < array.length; counter++)
			if (array[counter] == key)
				return counter;
		return -1;
	}

	public void actionPerformed(ActionEvent actionEvent) {
		String searchKey = actionEvent.getActionCommand();
		int element = linearSearch(array, Integer.parseInt(searchKey));
		if (element != -1)
			resultField.setText("Found value in element " + element);
		else
			resultField.setText("Value not found");
	}
}
