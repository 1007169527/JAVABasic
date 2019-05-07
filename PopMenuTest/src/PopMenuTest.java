
//P516
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class PopMenuTest extends JFrame {
	private JRadioButtonMenuItem items[];
	private final Color colorValues[] = { Color.BLUE, Color.YELLOW, Color.RED };
	private String colors[] = { "blue", "yellow", "red" };
	private JPopupMenu popupMenu;

	public PopMenuTest() {
		super("Testing PopMenu");
		ItemHandler handler = new ItemHandler();
		ButtonGroup colorGroup = new ButtonGroup();
		popupMenu = new JPopupMenu();
		items = new JRadioButtonMenuItem[3];

		for (int count = 0; count < items.length; count++) {
			items[count] = new JRadioButtonMenuItem(colors[count]);
			popupMenu.add(items[count]);
			items[count].addActionListener(handler);
			colorGroup.add(items[count]);
		}

		getContentPane().setBackground(Color.WHITE);

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				checkForTriggerEvent(event);
			}

			public void mouseRelease(MouseEvent event) {
				checkForTriggerEvent(event);
			}

			private void checkForTriggerEvent(MouseEvent event) {
				// TODO Auto-generated method stub
				if (event.isPopupTrigger())
					popupMenu.show(event.getComponent(), event.getX(), event.getY());
			}
		});

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		PopMenuTest popMenuTest = new PopMenuTest();
		popMenuTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ItemHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			for (int i = 0; i < items.length; i++) {
				if (e.getSource() == items[i]) {
					getContentPane().setBackground(colorValues[i]);
				}
			}
		}

	}

}