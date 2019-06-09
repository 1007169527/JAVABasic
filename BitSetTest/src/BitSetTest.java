import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.BitSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BitSetTest extends JFrame {
	private BitSet sieve;
	private JLabel statusLabel;
	private JTextField inputField;

	public BitSetTest() {
		// TODO Auto-generated constructor stub
		super("BitSets");
		sieve = new BitSet(1024);
		Container container = getContentPane();

		statusLabel = new JLabel();
		container.add(statusLabel, BorderLayout.SOUTH);

		JPanel inputPanel = new JPanel();
		inputPanel.add(new JLabel("Enter a number from 2 to 1023"));

		inputField = new JTextField(10);
		inputPanel.add(inputField);
		container.add(inputPanel, BorderLayout.NORTH);
		inputField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(inputField.getText());
				if (sieve.get(value))
					statusLabel.setText(value + " is a prime number");
				else
					statusLabel.setText(value + " is not a prime number");
			}
		});

		JTextArea primeArea = new JTextArea();
		container.add(new JScrollPane(primeArea), BorderLayout.CENTER);
		int size = sieve.size();
		for (int i = 2; i < size; i++)
			sieve.set(i);
		int finalBit = (int) Math.sqrt(size);
		for (int i = 2; i < finalBit; i++) {
			if (sieve.get(i)) {
				for (int j = 2 * i; j < size; j += i)
					sieve.clear(j);
			}
		}
		int counter = 0;
		for (int i = 2; i < size; i++) {
			if (sieve.get(i)) {
				primeArea.append(String.valueOf(i));
				primeArea.append(++counter % 7 == 0 ? "\n" : "\t");
			}
		}

		setSize(600, 450);
		setVisible(true);
	}

	public static void main(String[] args) {
		BitSetTest application = new BitSetTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
