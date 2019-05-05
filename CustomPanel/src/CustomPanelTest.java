
//P500
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CustomPanelTest extends JFrame {
	private JPanel buttonPanel;
	private CustomPanel myPanel;
	private JButton circleButton, squareButton;

	public CustomPanelTest() {
		// TODO Auto-generated constructor stub
		super("Testing CustomPanel");
		myPanel = new CustomPanel();
		myPanel.setBackground(Color.GREEN);
		squareButton = new JButton("Square");
		squareButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				myPanel.draw(CustomPanel.SQUARE);
			}
		});

		circleButton = new JButton("Circle");
		circleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				myPanel.draw(CustomPanel.CIRCLE);
			}
		});

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(circleButton);
		buttonPanel.add(squareButton);

		Container container = getContentPane();
		container.add(myPanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		CustomPanelTest customPanelTest = new CustomPanelTest();
		customPanelTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
