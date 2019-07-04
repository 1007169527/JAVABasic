
//850
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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

	private Map map;

	public WordTypeCount() {
		// TODO Auto-generated constructor stub
		super("WordTypeCount");
		inputField = new JTextArea(3, 30);

		map = new HashMap<String, Integer>();

		goButton = new JButton("go");
		goButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createMap();
				display.setText(creatOutput());
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

	protected void createMap() {
		// TODO Auto-generated method stub
		String input = inputField.getText();
		StringTokenizer tokenizer = new StringTokenizer(input);
		map.clear();
		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken().toLowerCase();
			if (map.containsKey(word)) {
				Integer count = (Integer) map.get(word);
				map.put(word, count.intValue() + 1);
			} else {
				map.put(word, 1);
			}
		}
	}

	protected String creatOutput() {
		// TODO Auto-generated method stub
		StringBuffer output = new StringBuffer("");
		Iterator keys = map.keySet().iterator();

		while (keys.hasNext()) {
			Object currentKey = keys.next();
			output.append(currentKey + "\t" + map.get(currentKey) + "\n");
		}

		output.append("size " + map.size() + "\n");
		output.append("is Empty: " + map.isEmpty() + "\n");

		return output.toString();
	}

	public static void main(String[] args) {
		WordTypeCount application = new WordTypeCount();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
