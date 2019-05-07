
//P524
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class TabbedPaneTest extends JFrame {
	public TabbedPaneTest() {
		// TODO Auto-generated constructor stub
		super("Testing TabbedPane");
		JTabbedPane tabbedPane = new JTabbedPane();
		JLabel label1 = new JLabel("panel one", SwingConstants.CENTER);
		JPanel panel1 = new JPanel();
		panel1.add(label1);
		tabbedPane.addTab("Tab one", null, panel1, "First Panel");

		JLabel label2 = new JLabel("panel two", SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.YELLOW);
		panel2.add(label2);
		tabbedPane.addTab("Tab two", null, panel2, "Second Panel");

		JLabel label3 = new JLabel("panel three");
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(new JButton("North"), BorderLayout.NORTH);
		panel3.add(new JButton("South"), BorderLayout.SOUTH);
		panel3.add(new JButton("East"), BorderLayout.EAST);
		panel3.add(new JButton("West"), BorderLayout.WEST);
		panel3.add(label3, BorderLayout.CENTER);
		tabbedPane.addTab("Tab three", null, panel3, "Third Panel");

		getContentPane().add(tabbedPane);
		setSize(450, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		TabbedPaneTest tabbedPaneTest = new TabbedPaneTest();
		tabbedPaneTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
