
//P399
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValidateFrame extends JFrame {
	private JTextField phoneTextField, zipTextField, stateTextField, cityTextField, addressTextField, firstTextField,
			lastTextField;

	public ValidateFrame() {
		super("Validate");

		JLabel phoneLabel = new JLabel("Phone");
		JLabel zipLabel = new JLabel("ZIP");
		JLabel stateLabel = new JLabel("State");
		JLabel cityLabel = new JLabel("City");
		JLabel addressLabel = new JLabel("Adress");
		JLabel firstLabel = new JLabel("First Name");
		JLabel lastLabel = new JLabel("Last Name");

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				validateNow();
				// validateSmall();
			}
		});

		phoneTextField = new JTextField(15);
		zipTextField = new JTextField(15);
		stateTextField = new JTextField(15);
		cityTextField = new JTextField(15);
		addressTextField = new JTextField(15);
		firstTextField = new JTextField(15);
		lastTextField = new JTextField(15);

		JPanel firstName = new JPanel();
		firstName.add(firstLabel);
		firstName.add(firstTextField);
		JPanel lastName = new JPanel();
		lastName.add(lastLabel);
		lastName.add(lastTextField);
		JPanel address1 = new JPanel();
		address1.add(addressLabel);
		address1.add(addressTextField);
		JPanel address2 = new JPanel();
		address2.add(cityLabel);
		address2.add(cityTextField);
		address2.add(stateLabel);
		address2.add(stateTextField);
		address2.add(zipLabel);
		address2.add(zipTextField);
		JPanel phone = new JPanel();
		phone.add(phoneLabel);
		phone.add(phoneTextField);

		JPanel ok = new JPanel();
		ok.add(okButton);

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		container.add(firstName);
		container.add(lastName);
		container.add(address1);
		container.add(address2);
		container.add(phone);
		container.add(ok);

		setSize(825, 225);
		setVisible(true);
	}

	public static void main(String args[]) {
		ValidateFrame application = new ValidateFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void validateSmall() {
		if (!zipTextField.getText().matches("\\d{5}"))
			JOptionPane.showMessageDialog(this, "Invalid zip 1");
		else
			JOptionPane.showMessageDialog(this, "Thank you!");
	}

	private void validateNow() {
		if (lastTextField.getText().equals("") || firstTextField.getText().equals("")
				|| addressTextField.getText().equals("") || cityTextField.getText().equals("")
				|| stateTextField.getText().equals("") || zipTextField.getText().equals("")
				|| phoneTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please fill all fields !");
		} else if (!firstTextField.getText().matches("[A-Z][a-zA-Z]*"))
			JOptionPane.showMessageDialog(this, "Invalid first name");
		else if (!lastTextField.getText().matches("[A-Z][a-zA-Z]*"))
			JOptionPane.showMessageDialog(this, "Invalid last name");
		else if (!addressTextField.getText().matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))
			JOptionPane.showMessageDialog(this, "Invalid address");
		else if (!cityTextField.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))
			JOptionPane.showMessageDialog(this, "Invalid city");
		else if (!stateTextField.getText().matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))
			JOptionPane.showMessageDialog(this, "Invalid state");
		else if (!zipTextField.getText().matches("\\d{5}"))
			JOptionPane.showMessageDialog(this, "Invalid zip");
		else if (!phoneTextField.getText().matches("[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}"))
			JOptionPane.showMessageDialog(this, "Invalid phone number");
		else
			JOptionPane.showMessageDialog(this, "Thank you!");
	}

}
