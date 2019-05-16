import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankUI extends JPanel {
	protected final static String names[] = { "Account number", "First Name", "Last Name", "Balance",
			"Transaction Amount" };
	protected JLabel labels[];
	protected JTextField fields[];
	protected JButton doTask1, doTask2;
	protected JPanel innerPanelCenter, innerPanelSouth;
	protected int size;

	public static final int ACCOUNT = 0, FIRSTNAME = 1, LASTNAME = 2, BALANCE = 3, TRANSACTION = 4;

	public BankUI(int mySize) {
		size = mySize;
		labels = new JLabel[size];
		fields = new JTextField[size];

		innerPanelCenter = new JPanel();
		innerPanelCenter.setLayout(new GridLayout(size, 2));

		for (int count = 0; count < labels.length; count++) {
			labels[count] = new JLabel(names[count]);
			fields[count] = new JTextField();
			innerPanelCenter.add(labels[count]);
			innerPanelCenter.add(fields[count]);
		}

		innerPanelSouth = new JPanel();
		doTask1 = new JButton();
		doTask2 = new JButton();
		innerPanelSouth.add(doTask1);
		innerPanelSouth.add(doTask2);

		setLayout(new BorderLayout());
		add(innerPanelCenter, BorderLayout.CENTER);
		add(innerPanelSouth, BorderLayout.SOUTH);

		validate();
	}

	public JButton getDoTask1Button() {
		return doTask1;
	}

	public JButton getDoTask2Button() {
		return doTask2;
	}

	public JTextField[] getField() {
		return fields;
	}

	public void clearFields() {
		for (int count = 0; count < size; count++) {
			fields[count].setText("");
		}
	}

	public void setFieldValues(String strings[]) throws IllegalArgumentException {
		if (strings.length != size)
			throw new IllegalArgumentException("There must be " + size + " Strings in the array");
		for (int count = 0; count < size; count++) {
			fields[count].setText(strings[count]);
		}
	}

	public String[] getFieldValues() {
		String values[] = new String[size];
		for (int count = 0; count < size; count++) {
			values[count] = fields[count].getText();
		}
		return values;
	}

}
