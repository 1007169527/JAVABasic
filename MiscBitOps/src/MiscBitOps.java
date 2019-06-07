
//P817
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiscBitOps extends JFrame {
	private JTextField input1Field, input2Field, bits1Field, bits2Field, bits3Field, resultField;
	private int value1, value2;

	public MiscBitOps() {
		// TODO Auto-generated constructor stub
		super("Bitwise operators");
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(4, 2));
		inputPanel.add(new JLabel("Enter 2 ints"));
		inputPanel.add(new JLabel(""));

		inputPanel.add(new JLabel("Value 1"));
		input1Field = new JTextField(8);
		inputPanel.add(input1Field);

		inputPanel.add(new JLabel("Value 2"));
		input2Field = new JTextField(8);
		inputPanel.add(input2Field);

		inputPanel.add(new JLabel("Result "));
		resultField = new JTextField(8);
		resultField.setEditable(false);
		inputPanel.add(resultField);

		JPanel bitsPanel = new JPanel();
		bitsPanel.setLayout(new GridLayout(4, 1));
		bitsPanel.add(new JLabel("Bit representations"));

		bits1Field = new JTextField(32);
		bits1Field.setEditable(false);
		bitsPanel.add(bits1Field);

		bits2Field = new JTextField(32);
		bits2Field.setEditable(false);
		bitsPanel.add(bits2Field);

		bits3Field = new JTextField(32);
		bits3Field.setEditable(false);
		bitsPanel.add(bits3Field);

		JPanel buttonPanel = new JPanel();

		JButton andButton = new JButton("AND");
		buttonPanel.add(andButton);
		andButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setFields();
				resultField.setText(Integer.toString(value1 & value2));
				bits3Field.setText(getBits(value1 & value2));
			}
		});

		JButton inclusiveOrButton = new JButton("Inclusive OR");
		buttonPanel.add(inclusiveOrButton);
		inclusiveOrButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setFields();
				resultField.setText(Integer.toString(value1 | value2));
				bits3Field.setText(getBits(value1 | value2));
			}
		});

		JButton exclusiveOrButton = new JButton("Exclusive OR");
		buttonPanel.add(exclusiveOrButton);
		exclusiveOrButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setFields();
				resultField.setText(Integer.toString(value1 ^ value2));
				bits3Field.setText(getBits(value1 ^ value2));
			}
		});

		JButton complementButton = new JButton("Complement");
		buttonPanel.add(complementButton);
		complementButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				input2Field.setText("");
				bits2Field.setText("");
				int value = Integer.parseInt(input1Field.getText());
				resultField.setText(Integer.toString(~value));
				bits1Field.setText(getBits(value));
				bits3Field.setText(getBits(~value));
			}
		});

		Container container = getContentPane();
		container.add(inputPanel, BorderLayout.WEST);
		container.add(bitsPanel, BorderLayout.EAST);
		container.add(buttonPanel, BorderLayout.SOUTH);

		setSize(600, 150);
		setVisible(true);
	}

	protected void setFields() {
		// TODO Auto-generated method stub
		value1 = Integer.parseInt(input1Field.getText());
		value2 = Integer.parseInt(input2Field.getText());
		bits1Field.setText(getBits(value1));
		bits2Field.setText(getBits(value2));
	}

	protected String getBits(int value) {
		// TODO Auto-generated method stub
		int displayMask = 1 << 31;
		StringBuffer buffer = new StringBuffer(32); // origin is 35 here why?
		for (int bit = 1; bit <= 32; bit++) {
			buffer.append((value & displayMask) == 0 ? '0' : '1');
			value <<= 1;
			if (bit % 8 == 0)
				buffer.append(' ');
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		MiscBitOps application = new MiscBitOps();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
