
//P592
import javax.swing.JTextArea;

public class RunnableOutput implements Runnable {
	private JTextArea outputArea;
	private String messageToAppend;

	public RunnableOutput(JTextArea output, String message) {
		// TODO Auto-generated constructor stub
		outputArea = output;
		messageToAppend = message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		outputArea.append(messageToAppend);
	}

}
