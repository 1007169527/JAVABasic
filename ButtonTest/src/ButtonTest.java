
//459
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ButtonTest extends JFrame {
	private JButton plainButton, fancyButton;

	public ButtonTest() {
		super("Testing Button");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		plainButton = new JButton("plain button");
		container.add(plainButton);

		Icon icon1 = new ImageIcon("home.gif");
		Icon icon2 = new ImageIcon("focus.gif");
		fancyButton = new JButton("fancy button", icon1);
		fancyButton.setRolloverIcon(icon2);
		container.add(fancyButton);

		ButtonHandler buttonHandler = new ButtonHandler();
		plainButton.addActionListener(buttonHandler);
		fancyButton.addActionListener(buttonHandler);

		setSize(275, 100);
		setVisible(true);
	}

	public static void main(String args[]) {
		ButtonTest buttonTest = new ButtonTest();
		buttonTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(ButtonTest.this, "You press " + event.getActionCommand());
		}
	}
}
