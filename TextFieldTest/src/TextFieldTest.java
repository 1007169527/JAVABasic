import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFieldTest extends JFrame {
	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;

	public TextFieldTest() {
		super("Testing JTextField and JPasswordField");

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		textField1 = new JTextField(10);
		container.add(textField1);

		textField2 = new JTextField("Enter text here");
		container.add(textField2);

		textField3 = new JTextField("Uneditable textField", 20);
		textField3.setEditable(false);
		container.add(textField3);

		passwordField = new JPasswordField("Hidden text");
		container.add(passwordField);

		TextFieldHandler textFieldHandler = new TextFieldHandler();
		textField1.addActionListener(textFieldHandler);
		textField2.addActionListener(textFieldHandler);
		textField3.addActionListener(textFieldHandler);
		passwordField.addActionListener(textFieldHandler);

		setSize(325, 100);
		setVisible(true);
	}

	public static void main(String args[]) {
		TextFieldTest appFieldTest = new TextFieldTest();
		appFieldTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class TextFieldHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String string = "";
			if (event.getSource() == textField1)
				string = "TextField1: " + event.getActionCommand();
			if (event.getSource() == textField2)
				string = "TextField2: " + event.getActionCommand();
			if (event.getSource() == textField3)
				string = "TextField3: " + event.getActionCommand();
			if (event.getSource() == passwordField)
				string = "PasswordField: " + new String(passwordField.getPassword());
			JOptionPane.showMessageDialog(null, string);
		}
	}
}
