
//P518
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class LookAndFeelTest extends JFrame {
	private final String strings[] = { "Metal", "Motif", "Windows" };
	private UIManager.LookAndFeelInfo looks[];
	private JRadioButton radio[];
	private ButtonGroup group;
	private JButton button;
	private JLabel label;
	private JComboBox comboBox;

	public LookAndFeelTest() {
		// TODO Auto-generated constructor stub
		super("Testing LookAndFeel");
		Container container = getContentPane();
		looks = UIManager.getInstalledLookAndFeels();
		if (looks.length == 0)
			return;
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(3, 1, 0, 5));
		container.add(northPanel);

		label = new JLabel("This is a Metal look-and-feel", SwingConstants.CENTER);
		northPanel.add(label);

		button = new JButton("JButton");
		northPanel.add(button);

		comboBox = new JComboBox();
		northPanel.add(comboBox);

		if (looks.length < 3)
			radio = new JRadioButton[looks.length];
		else
			radio = new JRadioButton[3];

		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, radio.length));

		group = new ButtonGroup();

		ItemHandler handler = new ItemHandler();

		for (int count = 0; count < radio.length; count++) {
			radio[count] = new JRadioButton(looks[count].getClassName());
			comboBox.addItem(looks[count].getClassName());
			radio[count].addItemListener(handler);
			group.add(radio[count]);
			southPanel.add(radio[count]);
		}

		container.add(southPanel, BorderLayout.SOUTH);
		container.add(northPanel, BorderLayout.NORTH);

		setSize(300, 200);
		setVisible(true);

		radio[0].setSelected(true);
	}

	private void changeTheLookAndFeel(int value) {
		try {
			UIManager.setLookAndFeel(looks[value].getClassName());
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private class ItemHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			for (int count = 0; count < radio.length; count++) {
				if (radio[count].isSelected()) {
					label.setText("This is a " + looks[count].getClassName() + " look-and-feel");
					comboBox.setSelectedIndex(count);
					changeTheLookAndFeel(count);
				}
			}
		}

	}

	public static void main(String[] args) {
		LookAndFeelTest lookAndFeelTest = new LookAndFeelTest();
		lookAndFeelTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
