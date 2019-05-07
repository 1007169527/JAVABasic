
//P529
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridBagTest extends JFrame {
	private Container container;
	private GridBagLayout layout;
	private GridBagConstraints constraints;

	public GridBagTest() {
		// TODO Auto-generated constructor stub
		super("Testing GridBag");
		container = getContentPane();
		layout = new GridBagLayout();
		container.setLayout(layout);
		constraints = new GridBagConstraints();

		JTextArea textArea1 = new JTextArea("TextArea1", 5, 10);
		JTextArea textArea2 = new JTextArea("TextArea2", 2, 2);

		String names[] = { "Iron", "Steel", "Brass" };
		JComboBox combox = new JComboBox(names);
		JTextField textField = new JTextField("TextField");
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");

		constraints.fill = GridBagConstraints.BOTH;
		addComponent(textArea1, 0, 0, 1, 3);
		addComponent(button1, 0, 1, 2, 1);
		addComponent(combox, 2, 1, 2, 1);
		constraints.weightx = 1000;
		constraints.weighty = 1;
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(button2, 1, 1, 1, 1);
		constraints.weightx = 0;
		constraints.weighty = 0;
		constraints.fill = GridBagConstraints.BOTH;
		addComponent(textField, 3, 0, 2, 1);
		addComponent(textArea2, 3, 2, 1, 1);
		setSize(300, 150);
		setVisible(true);
	}

	private void addComponent(Component component, int row, int colum, int width, int height) {
		// TODO Auto-generated method stub
		constraints.gridx = colum;
		constraints.gridy = row;
		constraints.gridwidth = width;
		constraints.gridheight = height;
		layout.setConstraints(component, constraints);
		container.add(component);
	}

	public static void main(String[] args) {
		GridBagTest gridBagTest = new GridBagTest();
		gridBagTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
