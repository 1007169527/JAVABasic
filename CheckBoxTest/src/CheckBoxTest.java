
//P461
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CheckBoxTest extends JFrame {
	private JTextField field;
	private JCheckBox bold, italic;

	public CheckBoxTest() {
		super("Testing CheckBox");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		field = new JTextField("Watch the font style change", 20);
		field.setFont(new Font("Serif", Font.PLAIN, 14));
		container.add(field);

		bold = new JCheckBox("Bold");
		container.add(bold);

		italic = new JCheckBox("Italic");
		container.add(italic);

		CheckBoxHandler handler = new CheckBoxHandler();
		bold.addItemListener(handler);
		italic.addItemListener(handler);

		setSize(275, 100);
		setVisible(true);
	}

	public static void main(String args[]) {
		CheckBoxTest checkBoxTest = new CheckBoxTest();
		checkBoxTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class CheckBoxHandler implements ItemListener {
		private int valBold = Font.PLAIN;
		private int valItalic = Font.PLAIN;

		public void itemStateChanged(ItemEvent event) {
			if (event.getSource() == bold)
				valBold = bold.isSelected() ? Font.BOLD : Font.PLAIN;
			if (event.getSource() == italic)
				valItalic = italic.isSelected() ? Font.ITALIC : Font.PLAIN;
			field.setFont(new Font("Serif", valBold + valItalic, 14));
		}
	}
}
