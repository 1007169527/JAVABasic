
//P809
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WordTypeCount extends JFrame {

	private JTextArea inputField;
	private JLabel prompt;
	private JTextArea display;
	private JButton goButton;

	private Hashtable table;

	public WordTypeCount() {
		// TODO Auto-generated constructor stub
		super("Word Type Count");
		inputField = new JTextArea(3, 20);
		table = new Hashtable();
		goButton = new JButton("Go");
		goButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createTable();
				display.setText(createOutput());
				;
			}
		});
		prompt = new JLabel("Enter a string");
		display = new JTextArea(15, 20);
		display.setEditable(false);

		JScrollPane displayScrollPane = new JScrollPane(display);
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(prompt);
		container.add(inputField);
		container.add(goButton);
		container.add(displayScrollPane);
		setSize(400, 400);
		setVisible(true);
	}

	protected void createTable() {
		// TODO Auto-generated method stub
		table.clear();
		String input = inputField.getText();
		StringTokenizer words = new StringTokenizer(input, " \n\t\r");
		while (words.hasMoreTokens()) {
			String word = words.nextToken().toLowerCase();
			if (table.containsKey(word)) {
				table.put(word, (int) (table.get(word)) + 1);
			} else
				table.put(word, 1);
		}
	}

	protected String createOutput() {
		// TODO Auto-generated method stub
		String output = "";
		Enumeration keys = table.keys();
		while (keys.hasMoreElements()) {
			Object currentKey = keys.nextElement();
			output += currentKey + "\t" + table.get(currentKey) + "\n";
		}
		output += "size: " + table.size() + "\n";
		output += "is Empty: " + table.isEmpty() + "\n";
		return output;
	}

	public static void main(String[] args) {
		WordTypeCount application = new WordTypeCount();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
