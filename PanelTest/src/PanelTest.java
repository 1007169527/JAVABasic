
//P486
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelTest extends JFrame {
	private JButton buttons[];
	private JPanel buttonPanel;

	public PanelTest() {
		// TODO Auto-generated constructor stub
		super("Testing Panel");
		Container container = getContentPane();
		buttons = new JButton[5];
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, buttons.length));
		for (int count = 0; count < buttons.length; count++) {
			buttons[count] = new JButton("Button " + (count + 1));
			buttonPanel.add(buttons[count]);
		}
		container.add(buttonPanel);
		setSize(425, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		PanelTest panelTest = new PanelTest();
		panelTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
