
//P463
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RadioCheckButtonTest extends JFrame {
	private JTextField field;
	private JRadioButton plainButton, boldButton, italicButton, bolditalicButton;
	private Font plainFont, boldFont, italicFont, boldItalicFont;
	private ButtonGroup radioGroup;

	public RadioCheckButtonTest() {
		super("Testing RadioCheckButton");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		field = new JTextField("Watch the font style change", 25);
		container.add(field);

		plainButton = new JRadioButton("Plain", true);
		container.add(plainButton);

		boldButton = new JRadioButton("Bold", false);
		container.add(boldButton);

		italicButton = new JRadioButton("Italic", false);
		container.add(italicButton);

		bolditalicButton = new JRadioButton("Bold and Italic", false);
		container.add(bolditalicButton);

		radioGroup = new ButtonGroup();
		radioGroup.add(plainButton);
		radioGroup.add(boldButton);
		radioGroup.add(italicButton);
		radioGroup.add(bolditalicButton);

		plainFont = new Font("Serif", Font.PLAIN, 14);
		boldFont = new Font("Serif", Font.BOLD, 14);
		italicFont = new Font("Serif", Font.ITALIC, 14);
		boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		field.setFont(plainFont);

		plainButton.addItemListener(new RadioButtonHandler(plainFont));
		boldButton.addItemListener(new RadioButtonHandler(boldFont));
		italicButton.addItemListener(new RadioButtonHandler(italicFont));
		bolditalicButton.addItemListener(new RadioButtonHandler(boldItalicFont));

		setSize(800, 80);
		setVisible(true);
	}

	private class RadioButtonHandler implements ItemListener {
		private Font font;

		public RadioButtonHandler(Font f) {
			font = f;
		}

		public void itemStateChanged(ItemEvent event) {
			field.setFont(font);
		}
	}

	public static void main(String args[]) {
		RadioCheckButtonTest radioCheckButtonTest = new RadioCheckButtonTest();
		radioCheckButtonTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
