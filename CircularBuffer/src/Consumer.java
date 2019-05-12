
//P593
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Consumer extends Thread {
	private Buffer shareLocation;
	private JTextArea outputArea;

	public Consumer(Buffer shared, JTextArea output) {
		// TODO Auto-generated constructor stub
		super("Consumer");
		shareLocation = shared;
		outputArea = output;
	}

	public void run() {
		int sum = 0;
		for (int count = 1; count <= 10; count++) {
			try {
				Thread.sleep((int) (Math.random() * 3001));
				sum += shareLocation.get();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String name = getName();
			SwingUtilities.invokeLater(new RunnableOutput(outputArea, "\n" + name + " done consuming.\n"));
		}
	}
}
