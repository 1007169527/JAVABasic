
//P395
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TokenTest extends JFrame {
	private JLabel promptLabel;
	private JTextField inputField;
	private JTextArea outputArea;

	public TokenTest() {
		super("Testing Class StringTokenizer!");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		promptLabel = new JLabel("Enter a sentence and press Enter!");
		container.add(promptLabel);
		inputField = new JTextField(20);
		inputField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				StringTokenizer tokens = new StringTokenizer(event.getActionCommand());
				outputArea.setText("Number of elements: " + tokens.countTokens() + "\nTokens are:\n");
				while (tokens.hasMoreTokens()) {
					outputArea.append(tokens.nextToken() + "\n");
				}
			}
		});
		container.add(inputField);
		outputArea = new JTextArea(10, 20);
		outputArea.setEditable(false);
		container.add(new JScrollPane(outputArea));
		setSize(275, 240);
		setVisible(true);
	}

	public static void main(String args[]) {
		TokenTest application = new TokenTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
