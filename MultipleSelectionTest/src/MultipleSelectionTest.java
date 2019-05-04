
//P468
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionTest extends JFrame {
	private JList colorList, copyList;
	private JButton copyButton;
	private final String colorNames[] = { "Black", "Blue", "Cyan", "Orange", "Pink", "Red", "White", "Yellow" };

	public MultipleSelectionTest() {
		super("Testing MultipleSelection");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(5);
		colorList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		container.add(new JScrollPane(colorList));

		copyButton = new JButton("Copy >>>>");
		copyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				List<String> strings = colorList.getSelectedValuesList();
				Vector<String> stringVector = new Vector<String>();
				for (String string : strings)
					stringVector.add(string);
				copyList.setListData(stringVector);
			}
		});
		container.add(copyButton);

		copyList = new JList();
		copyList.setVisibleRowCount(5);
		copyList.setFixedCellHeight(15);
		copyList.setFixedCellWidth(100);
		copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		container.add(new JScrollPane(copyList));

		setSize(400, 200);
		setVisible(true);
	}

	public static void main(String args[]) {
		MultipleSelectionTest multipleSelectionTest = new MultipleSelectionTest();
		multipleSelectionTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
