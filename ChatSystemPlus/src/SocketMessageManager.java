
//P730
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.StringTokenizer;

public class SocketMessageManager implements MessageManager {
	private SocketChannel socketChannel;
	private MessageListener messageListener;
	private String serverAddress;
	private ReceivingThread receiveMessage;
	private boolean connected;
	private Charset charSet = Charset.forName("UTF-8");
	private ByteBuffer writeBuffer;
	private ByteBuffer readBuffer = ByteBuffer.allocate(512);

	public SocketMessageManager(String host) {
		// TODO Auto-generated constructor stub
		serverAddress = host;
		connected = false;
	}

	@Override
	public void connect(MessageListener listener) {
		// TODO Auto-generated method stub
		messageListener = listener;
		try {
			socketChannel = socketChannel.open();
			socketChannel.connect(new InetSocketAddress(InetAddress.getByName(serverAddress), 12345));
			receiveMessage = new ReceivingThread();
			receiveMessage.start();
			connected = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void disconnect(MessageListener listener) {
		// TODO Auto-generated method stub
		if (connected) {
			try {
				sendMessage("", "Dosconnect");
				connected = false;
				receiveMessage.interrupt();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	@Override
	public void sendMessage(String userName, String messageBody) {
		// TODO Auto-generated method stub
		String message = userName + "> " + messageBody;
		try {
			writeBuffer = charSet.encode(message);
			socketChannel.write(writeBuffer);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				socketChannel.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	public class ReceivingThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			int messageLength = 0;
			String message = "";
			try {
				do {
					readBuffer.clear();
					socketChannel.read(readBuffer);
					readBuffer.flip();
					CharBuffer charMessage = charSet.decode(readBuffer);
					message = charMessage.toString().trim();
					StringTokenizer tokenizer = new StringTokenizer(message, ">");
					if (tokenizer.countTokens() == 2)
						messageListener.messageReceived(tokenizer.nextToken(), tokenizer.nextToken());
				} while (true);
			} catch (IOException e) {
				// TODO: handle exception
				if (e instanceof ClosedByInterruptException)
					System.out.println("socket channel closed");
				else {
					e.printStackTrace();
					try {
						socketChannel.close();
						System.out.println("socket channel closed");
					} catch (Exception e2) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}
	}
}
