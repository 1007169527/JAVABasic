
//P710
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

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
			MulticastSocket multicastSocket = new MulticastSocket(SocketMessengerConstants.MULTICAST_LISTENING_PORT);
			InetAddress multicastGroup = InetAddress.getByName(SocketMessengerConstants.MULTICAST_ADDRESS);
			multicastSocket.joinGroup(multicastGroup);
			DatagramSocket socket = new DatagramSocket(SocketMessengerConstants.MULTICAST_SENDING_PORT);
			InetAddress group = InetAddress.getByName(SocketMessengerConstants.MULTICAST_ADDRESS);
			DatagramPacket packet = new DatagramPacket(messageBytes, messageBytes.length, group,
					SocketMessengerConstants.MULTICAST_LISTENING_PORT);
			multicastSocket.send(packet);
			// if (socket.getBroadcast())
			// System.out.println("Broadcast on");
			// else
			// System.out.println("Broadcast off");
			socket.send(packet);
			// System.out.println("Multicast dealing with: " + new String(messageBytes));
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
