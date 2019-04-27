
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CharacterMethods extends JFrame {
	private char c;
	private JLabel promptLabel1;
	private JTextField inputField1;
	private JLabel promptLabel2;
	private JTextField inputField2;
	private JTextArea outputArea;
	private ScrollPane scrollPane;
	private int digit, radix;
	private boolean isIegalInput;

	public CharacterMethods() {
		super("StaticCharacterMethods");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		promptLabel1 = new JLabel("Enter a digit or a charater and press Enter");
		container.add(promptLabel1);
		inputField1 = new JTextField(5);
		inputField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String s = event.getActionCommand();
				c = s.charAt(0);
				buildOutput1();
			}
		});
		container.add(inputField1);
		promptLabel2 = new JLabel("Enter a radix (2/8/10/16) and press Enter");
		container.add(promptLabel2);
		inputField2 = new JTextField(5);
		inputField2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				isIegalInput = false;
				String radixString = "2, 8, 10, 16";
				radix = Integer.parseInt(inputField2.getText());
				if (radixString.contains(inputField2.getText())) {
					digit = -1;
					String s = inputField1.getText();
					String stdInputString1 = "a,b,c,d,e,f";
					String stdInputString2 = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,0";
					if (stdInputString1.contains(s.toLowerCase())) {
						isIegalInput = true;
						c = s.charAt(0);
					} else if (stdInputString2.contains(s)) {
						isIegalInput = true;
						digit = Integer.parseInt(s);
					}
					buildOutput2();
				}
			}
		});
		container.add(inputField2);
		outputArea = new JTextArea();
		scrollPane = new ScrollPane();
		scrollPane.setSize(300, 300);
		scrollPane.add(outputArea);
		container.add(scrollPane);
		setSize(400, 400);
		setVisible(true);
	}

	private void buildOutput1() {
		// P390
		outputArea.setText("in Output1\n");
		outputArea.append("is defined: " + Character.isDefined(c) + "\nis digit: " + Character.isDigit(c)
				+ "\nis first character in a java identifier: " + Character.isJavaIdentifierStart(c)
				+ "\nis part of a java identifier: " + Character.isJavaIdentifierPart(c) + "\nis letter: "
				+ Character.isLetter(c) + "\nis letter or digit: " + Character.isLetterOrDigit(c) + "\nis lower case: "
				+ Character.isLowerCase(c) + "\nis upper case: " + Character.isUpperCase(c) + "\nis upper case: "
				+ Character.toUpperCase(c) + "\nis lower case: " + Character.toLowerCase(c));
	}

	private void buildOutput2() {
		// P392
		outputArea.setText("in Output2\n");
		if (!isIegalInput) {
			outputArea.append("Here is an illegal input!");
			return;
		}
		if (digit != -1)
			outputArea.append("Convert digit to charater: " + Character.forDigit(digit, radix));
		else
			outputArea.append("\nConvert character to digit: " + Character.digit(c, radix));
	}

	public static void main(String args[]) {
		CharacterMethods application = new CharacterMethods();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
