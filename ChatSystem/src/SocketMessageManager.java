import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class SocketMessageManager implements MessageManager {
	private Socket clientSocket;
	private String serverAddress;
	private PacketReceivingThread receivingThread;
	private boolean connected = false;

	public SocketMessageManager(String address) {
		// TODO Auto-generated constructor stub
		serverAddress = address;
	}

	@Override
	public void connect(MessageListener listener) {
		// TODO Auto-generated method stub
		if (connected)
			return;
		try {
			clientSocket = new Socket(InetAddress.getByName(serverAddress), SocketMessengerConstants.SERVER_PORT);
			receivingThread = new PacketReceivingThread(listener);
			receivingThread.start();
			connected = true;
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void disconnct(MessageListener listener) {
		// TODO Auto-generated method stub
		if (!connected)
			return;
		try {
			Thread disconnectThread = new SendingThread(clientSocket, "", SocketMessengerConstants.DISCONNECT_STRING);
			disconnectThread.start();
			disconnectThread.join(10000);
			receivingThread.stopListening();
			clientSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		connected = false;
	}

	@Override
	public void sendMessage(String from, String message) {
		// TODO Auto-generated method stub
		if (!connected)
			return;
		new SendingThread(clientSocket, from, message).start();
	}

}
