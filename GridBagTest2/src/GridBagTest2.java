
//P532
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextField;

public class GridBagTest2 extends JFrame {
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private Container container;

	public GridBagTest2() {
		// TODO Auto-generated constructor stub
		super("Testing GridBag2");
		container = getContentPane();
		layout = new GridBagLayout();
		container.setLayout(layout);
		constraints = new GridBagConstraints();
		String metals[] = { "Copper", "Aluminum", "Silver" };
		JComboBox combobox = new JComboBox(metals);
		JTextField textField = new JTextField("TextField");
		String fonts[] = { "Serif", "Monospaced" };
		JList list = new JList(fonts);
		String names[] = { "zero", "one", "two", "three", "four" };
		JButton buttons[] = new JButton[names.length];
		for (int count = 0; count < buttons.length; count++)
			buttons[count] = new JButton(names[count]);
		constraints.weightx = 1;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(textField);
		constraints.gridwidth = 1;
		addComponent(buttons[0]);
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(buttons[1]);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(buttons[2]);
		constraints.weighty = 0;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(combobox);
		constraints.gridwidth = 1;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(buttons[3]);
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		addComponent(buttons[4]);
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		addComponent(list);
		setSize(300, 200);
		setVisible(true);

	}

	private void addComponent(Component component) {
		layout.setConstraints(component, constraints);
		container.add(component);
	}

	public static void main(String[] args) {
		GridBagTest2 gridBagTest2 = new GridBagTest2();
		gridBagTest2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
