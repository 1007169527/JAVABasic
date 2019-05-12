
//P595
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CircularBufferTest extends JFrame {
	JTextArea outputArea;

	public CircularBufferTest() {
		super("Test CircularBuffer");
		outputArea = new JTextArea(20, 30);
		outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		getContentPane().add(new JScrollPane(outputArea));
		setSize(310, 500);
		setVisible(true);
		CircularBuffer shareLocation = new CircularBuffer(outputArea);
		SwingUtilities.invokeLater(new RunnableOutput(outputArea, shareLocation.createStateOutput()));
		Producer producer = new Producer(shareLocation, outputArea);
		Consumer consumer = new Consumer(shareLocation, outputArea);
		producer.start();
		consumer.start();
	}

	public static void main(String[] args) {
		CircularBufferTest circularBufferTest = new CircularBufferTest();
		circularBufferTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
