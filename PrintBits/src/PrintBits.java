
//P816
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PrintBits extends JFrame {
	private JTextField outputField;

	public PrintBits() {
		super("Printing bit representation for numbers");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(new JLabel("Enter an integer"));
		JTextField inputField = new JTextField(10);
		container.add(inputField);
		inputField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int value = Integer.parseInt(e.getActionCommand());
				outputField.setText(getBits(value));
			}
		});
		container.add(new JLabel("The integer in bots is"));
		outputField = new JTextField(33);
		outputField.setEditable(false);
		container.add(outputField);
		setSize(720, 70);
		setVisible(true);
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
		PrintBits application = new PrintBits();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
