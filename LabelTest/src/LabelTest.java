import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelTest extends JFrame {
	private JLabel label1, label2, label3;

	public LabelTest() {
		super("Testing JLabel");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		container.add(label1);

		Icon icon = new ImageIcon("home.gif");
		label2 = new JLabel("Label with text and icon", icon, SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		container.add(label2);

		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(icon);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setText("This is label3");
		container.add(label3);

		setSize(275, 170);
		setVisible(true);
	}

	public static void main(String args[]) {
		LabelTest appLabelTest = new LabelTest();
		appLabelTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
