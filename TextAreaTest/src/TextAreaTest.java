
//P497
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaTest extends JFrame {
	private JTextArea textArea1, textArea2;
	private JButton copyButton;

	public TextAreaTest() {
		// TODO Auto-generated constructor stub
		super("Testing TextArea");
		Box box = Box.createHorizontalBox();
		String string = "This is demo string to\nillustrate copying text\nfrom one textarea to \nanother textarea using the\nexternal event";
		textArea1 = new JTextArea(string, 10, 15);
		box.add(new JScrollPane(textArea1));

		copyButton = new JButton("Copy >>>>");
		box.add(copyButton);
		copyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea2.setText(textArea1.getSelectedText());
			}
		});

		textArea2 = new JTextArea(10, 15);
		textArea2.setEditable(false);
		box.add(new JScrollPane(textArea2));

		Container container = getContentPane();
		container.add(box);

		setSize(425, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		TextAreaTest textAreaTest = new TextAreaTest();
		textAreaTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}