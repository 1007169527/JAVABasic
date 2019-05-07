
//P525
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class BoxLayoutTest extends JFrame {
	public BoxLayoutTest() {
		// TODO Auto-generated constructor stub
		super("Testing BoxLayout");
		Box horizontal1 = Box.createHorizontalBox();
		Box vertical1 = Box.createVerticalBox();
		Box horizontal2 = Box.createHorizontalBox();
		Box vertical2 = Box.createVerticalBox();

		final int SIZE = 3;

		for (int count = 0; count < SIZE; count++) {
			horizontal1.add(new JButton("Button " + count));
		}

		for (int count = 0; count < SIZE; count++) {
			vertical1.add(Box.createHorizontalStrut(25));
			vertical1.add(new JButton("Button " + count));
		}

		for (int count = 0; count < SIZE; count++) {
			horizontal2.add(Box.createHorizontalGlue());
			horizontal2.add(new JButton("Button " + count));
		}

		for (int count = 0; count < SIZE; count++) {
			vertical2.add(Box.createRigidArea(new Dimension(12, 8)));
			vertical2.add(new JButton("Button " + count));
		}

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		for (int count = 0; count < SIZE; count++) {
			panel.add(Box.createGlue());
			panel.add(new JButton("Button " + count));
		}

		JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabs.addTab("Horizontal1  Box", horizontal1);
		tabs.addTab("Vertical1 Box with Struts", vertical1);
		tabs.addTab("Horizontal2 BoX with Glue", horizontal2);
		tabs.addTab("Verical2 Box with Rigid Areas", vertical2);
		tabs.addTab("Vertical Box with Glue", panel);

		getContentPane().add(tabs);
		setSize(400, 220);
		setVisible(true);
	}

	public static void main(String[] args) {
		BoxLayoutTest boxLayoutTest = new BoxLayoutTest();
		boxLayoutTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
