
//P714
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SendingThread extends Thread {
	private Socket clientSocket;
	private String messageToSend;

	public SendingThread(Socket socket, String userName, String message) {
		// TODO Auto-generated constructor stub
		super("SendingThread: " + socket);
		clientSocket = socket;
		messageToSend = userName + SocketMessengerConstants.MESSAGE_SEPARATOR + message;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
			writer.println(messageToSend);
			writer.flush();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
