
//P467
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame {
	private JList colorList;
	private Container container;
	private final String colorNames[] = { "Black", "Blue", "Cyan", "Orange", "Pink", "Red", "White", "Yellow" };
	private final Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN, Color.ORANGE, Color.PINK, Color.RED,
			Color.WHITE, Color.YELLOW };

	public ListTest() {
		super("Test List");
		container = getContentPane();
		container.setLayout(new FlowLayout());

		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(5);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		container.add(new JScrollPane(colorList));

		colorList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				container.setBackground(colors[colorList.getSelectedIndex()]);
			}
		});

		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String args[]) {
		ListTest listTest = new ListTest();
		listTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
