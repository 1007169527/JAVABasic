import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSendingThread extends Thread {
	private byte[] messageBytes;

	public MulticastSendingThread(byte[] bytes) {
		// TODO Auto-generated constructor stub
		super("MulticastSendingThread");
		messageBytes = bytes;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			DatagramSocket socket = new DatagramSocket(SocketMessengerConstants.MULTICAST_SENDING_PORT);
			InetAddress group = InetAddress.getByName(SocketMessengerConstants.MULTICAST_ADDRESS);
			DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, group,
					SocketMessengerConstants.MULTICAST_LISTENING_PORT);
			socket.send(packet);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
