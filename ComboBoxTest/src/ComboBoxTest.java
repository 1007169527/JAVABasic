
//P465
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBoxTest extends JFrame {
	private JComboBox imageComboBox;
	private JLabel label;

	private String names[] = { "home.gif", "focus.gif", "help.gif", "clear.gif" };
	private Icon icons[] = { new ImageIcon(names[0]), new ImageIcon(names[1]), new ImageIcon(names[2]),
			new ImageIcon(names[3]) };

	public ComboBoxTest() {
		super("Testing ComboBox");
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		imageComboBox = new JComboBox(names);
		imageComboBox.setMaximumRowCount(3);
		imageComboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if (arg0.getStateChange() == ItemEvent.SELECTED)
					label.setIcon(icons[imageComboBox.getSelectedIndex()]);
			}
		});

		container.add(imageComboBox);
		label = new JLabel(icons[0]);
		container.add(label);

		setSize(350, 100);
		setVisible(true);
	}

	public static void main(String args[]) {
		ComboBoxTest comboBoxTest = new ComboBoxTest();
		comboBoxTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
