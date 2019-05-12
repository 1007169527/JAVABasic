
//P592
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Producer extends Thread {
	private Buffer shareLocation;
	private JTextArea outputArea;

	public Producer(Buffer shared, JTextArea output) {
		// TODO Auto-generated constructor stub
		super("Producer");
		shareLocation = shared;
		outputArea = output;
	}

	public void run() {
		for (int count = 11; count <= 20; count++) {
			try {
				Thread.sleep((int) (Math.random() * 3000));
				shareLocation.set(count);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			String name = getName();
			SwingUtilities.invokeLater(new RunnableOutput(outputArea, "\n" + name + " done producing.\n"));
		}
	}
}
