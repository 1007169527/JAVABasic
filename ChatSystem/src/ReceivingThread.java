
//P707
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class ReceivingThread extends Thread {
	private BufferedReader input;
	private MessageListener messageListener;
	private boolean keepListening = true;

	public ReceivingThread(MessageListener listener, Socket clientSocket) {
		// TODO Auto-generated constructor stub
		super("ReceivingThread: " + clientSocket);
		messageListener = listener;
		try {
			clientSocket.setSoTimeout(5000);
			input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		String message;
		while (keepListening) {
			try {
				message = input.readLine();
			} catch (InterruptedIOException e) {
				continue;
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				break;
			}
			if (message != null) {
				// System.out.println("server get message: " + message);
				StringTokenizer tokenizer = new StringTokenizer(message, SocketMessengerConstants.MESSAGE_SEPARATOR);
				if (tokenizer.countTokens() == 2)
					messageListener.messageReceived(tokenizer.nextToken(), tokenizer.nextToken());
				else if (message.equalsIgnoreCase(
						SocketMessengerConstants.MESSAGE_SEPARATOR + SocketMessengerConstants.DISCONNECT_STRING))
					stopListening();
			}
		}
		try {
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void stopListening() {
		keepListening = false;
	}
}
