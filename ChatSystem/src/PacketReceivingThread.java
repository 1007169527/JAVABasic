import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.StringTokenizer;

public class PacketReceivingThread extends Thread {
	private MessageListener messageListener;
	private MulticastSocket multicastSocket;
	private InetAddress multicastGroup;
	private boolean keepListening;

	public PacketReceivingThread(MessageListener listener) {
		// TODO Auto-generated constructor stub
		super("PacketReceivingThread");
		messageListener = listener;
		try {
			multicastSocket = new MulticastSocket(SocketMessengerConstants.MULTICAST_LISTENING_PORT);
			multicastGroup = InetAddress.getByName(SocketMessengerConstants.MULTICAST_ADDRESS);
			multicastSocket.setSoTimeout(5000);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while (keepListening) {
			byte[] buffer = new byte[SocketMessengerConstants.MESSAGE_SIZR];
			DatagramPacket packet = new DatagramPacket(buffer, SocketMessengerConstants.MESSAGE_SIZR);
			try {
				multicastSocket.receive(packet);
			} catch (InterruptedIOException e) {
				continue;
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				break;
			}
			String message = new String(packet.getData());
			message = message.trim();
			StringTokenizer tokenizer = new StringTokenizer(message, SocketMessengerConstants.MESSAGE_SEPARATOR);
			if (tokenizer.countTokens() == 2)
				messageListener.messageReceived(tokenizer.nextToken(), tokenizer.nextToken());
		}
		try {
			multicastSocket.leaveGroup(multicastGroup);
			multicastSocket.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void stopListening() {
		// TODO Auto-generated method stub
		keepListening = true;
	}
}
