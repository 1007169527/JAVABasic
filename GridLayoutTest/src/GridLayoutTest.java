import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame implements ActionListener {
	private JButton buttons[];
	private final String names[] = { "one", "two", "three", "four", "five", "six" };
	private boolean toggle = true;
	private Container container;
	private GridLayout grid1, grid2;

	public GridLayoutTest() {
		// TODO Auto-generated constructor stub
		super("Testing GridLayout");
		grid1 = new GridLayout(2, 3, 5, 5);
		grid2 = new GridLayout(3, 2);

		container = getContentPane();
		container.setLayout(grid1);

		buttons = new JButton[names.length];
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			container.add(buttons[count]);
		}

		setSize(300, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (toggle)
			container.setLayout(grid2);
		else
			container.setLayout(grid1);
		toggle = !toggle;
		container.validate();
	}

	public static void main(String[] args) {
		GridLayoutTest gridLayoutTest = new GridLayoutTest();
		gridLayoutTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
