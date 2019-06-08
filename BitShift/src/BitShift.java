
//P821
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BitShift extends JFrame {
	private JTextField bitsField, valueField;

	public BitShift() {
		// TODO Auto-generated constructor stub
		super("Shifts Bits");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		container.add(new JLabel("Integer to shifts"));
		valueField = new JTextField(12);
		container.add(valueField);
		valueField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(valueField.getText());
				bitsField.setText(getBits(value));
			}
		});

		bitsField = new JTextField(13);
		bitsField.setEditable(false);
		container.add(bitsField);

		JButton leftButton = new JButton("<<");
		container.add(leftButton);
		leftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(valueField.getText());
				value <<= 1;
				valueField.setText(Integer.toString(value));
				bitsField.setText(getBits(value));
			}
		});

		JButton rightSignButton = new JButton(">>");
		container.add(rightSignButton);
		rightSignButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(valueField.getText());
				value >>= 1;
				valueField.setText(Integer.toString(value));
				bitsField.setText(getBits(value));
			}
		});

		JButton rightZeroButton = new JButton(">>>");
		container.add(rightZeroButton);
		rightZeroButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(valueField.getText());
				value >>= 1;
				valueField.setText(Integer.toString(value));
				bitsField.setText(getBits(value));
			}
		});

		setSize(400, 120);
		setVisible(true);
	}

	protected String getBits(int value) {
		// TODO Auto-generated method stub
		int displayMask = 1 << 31;
		StringBuffer buffer = new StringBuffer(32);
		for (int bit = 1; bit <= 32; bit++) {
			buffer.append((value & displayMask) == 0 ? '0' : '1');
			value <<= 1;
			if (bit % 8 == 0)
				buffer.append(' ');
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		BitShift application = new BitShift();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
