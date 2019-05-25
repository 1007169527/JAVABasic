import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer implements MessageListener {
	public void startServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(SocketMessengerConstants.SERVER_PORT, 100);
			System.out.println("Server listening on port: " + SocketMessengerConstants.SERVER_PORT + "...");
			while (true) {
				Socket clientSocket = serverSocket.accept();
				new ReceivingThread(this, clientSocket).start();
				System.out.println("Connection received from: " + clientSocket.getInetAddress());
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void messageReceived(String from, String message) {
		// TODO Auto-generated method stub
		String completeMessage = from + SocketMessengerConstants.MESSAGE_SEPARATOR + message;
		new MulticastSendingThread(completeMessage.getBytes()).start();
	}

	public static void main(String[] args) {
		new MessageServer().startServer();
	}
}
