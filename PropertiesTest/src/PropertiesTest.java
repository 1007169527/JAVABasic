
//P811
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PropertiesTest extends JFrame {
	private JLabel statusLabel;
	private Properties table;
	private JTextArea displayArea;
	private JTextField valueField, nameField;

	public PropertiesTest() {
		// TODO Auto-generated constructor stub
		super("PropertiesTest");
		table = new Properties();
		Container container = getContentPane();
		JPanel northSubPanel = new JPanel();
		northSubPanel.add(new JLabel("Property value"));
		nameField = new JTextField(10);
		northSubPanel.add(nameField);
		northSubPanel.add(new JLabel("Property name(key)"));
		valueField = new JTextField(10);
		northSubPanel.add(valueField);
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.add(northSubPanel, BorderLayout.NORTH);
		statusLabel = new JLabel();
		northPanel.add(statusLabel, BorderLayout.SOUTH);
		container.add(northPanel, BorderLayout.NORTH);
		displayArea = new JTextArea(4, 35);
		container.add(new JScrollPane(displayArea), BorderLayout.CENTER);
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 5));
		JButton putButton = new JButton("Put");
		southPanel.add(putButton);
		putButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object value = table.setProperty(nameField.getText(), valueField.getText());
				if (value == null)
					showstatus("Put: " + nameField.getText() + " " + valueField.getText());
				else
					showstatus("Put: " + nameField.getText() + " " + valueField.getText() + "; Replaced: " + value);
				listProperties();
			}
		});

		JButton clearButton = new JButton("Clear");
		southPanel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				table.clear();
				showstatus("Table in memory cleared");
				listProperties();
			}
		});

		JButton getPropertyButton = new JButton("Get Property");
		southPanel.add(getPropertyButton);
		getPropertyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Object value = table.getProperty(nameField.getText());
				if (value != null)
					showstatus("Get property: " + nameField.getText() + " " + value.toString());
				else
					showstatus("Get property: " + nameField.getText() + " not in table");
			}
		});

		JButton saveButton = new JButton("Save");
		southPanel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FileOutputStream output = new FileOutputStream("props.dat");
					table.store(output, "Sample Properties");
					output.close();
					listProperties();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});

		JButton loadButton = new JButton("Load");
		southPanel.add(loadButton);
		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					FileInputStream input = new FileInputStream("props.dat");
					table.load(input);
					input.close();
					listProperties();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});

		container.add(southPanel, BorderLayout.SOUTH);
		setSize(550, 225);
		setVisible(true);
	}

	protected void listProperties() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		String name, value;
		Enumeration enumeration = table.propertyNames();
		while (enumeration.hasMoreElements()) {
			name = enumeration.nextElement().toString();
			value = table.getProperty(name);
			buffer.append(name).append('\t');
			buffer.append(value).append('\n');
		}
		displayArea.setText(buffer.toString());
	}

	protected void showstatus(String string) {
		// TODO Auto-generated method stub
		statusLabel.setText(string);
	}

	public static void main(String[] args) {
		PropertiesTest application = new PropertiesTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
