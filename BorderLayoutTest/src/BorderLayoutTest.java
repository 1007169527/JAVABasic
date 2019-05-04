
//P483
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame implements ActionListener {
	private JButton buttons[];
	private final String names[] = { "Hide North", "Hide South", "Hide East", "Hide West" };
	private BorderLayout layout;

	public BorderLayoutTest() {
		// TODO Auto-generated constructor stub
		super("Testing BorderLayout");
		layout = new BorderLayout(5, 5);
		Container container = getContentPane();
		container.setLayout(layout);

		buttons = new JButton[names.length];
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
		}

		container.add(buttons[0], BorderLayout.NORTH);
		container.add(buttons[1], BorderLayout.SOUTH);
		container.add(buttons[2], BorderLayout.EAST);
		container.add(buttons[3], BorderLayout.WEST);

		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int count = 0; count < names.length; count++) {
			if (e.getSource() == buttons[count])
				buttons[count].setVisible(false);
			else {
				buttons[count].setVisible(true);
			}
			layout.layoutContainer(getContentPane());
		}
	}

	public static void main(String[] args) {
		BorderLayoutTest borderLayoutTest = new BorderLayoutTest();
		borderLayoutTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
