
//P726

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MessagerNonBlockingServer extends JFrame {
	private ServerSocketChannel serverSocketChannel;
	private Selector selector;
	private Vector sockets = new Vector();
	private int counter = 0;
	private JTextArea displayArea;
	private Charset charSet;
	private ByteBuffer writeBuffer;
	private ByteBuffer readBuffer = ByteBuffer.allocate(512);

	public MessagerNonBlockingServer() {
		// TODO Auto-generated constructor stub
		super("MessagerNonBlockingServer");
		displayArea = new JTextArea();
		getContentPane().add(new JScrollPane(displayArea));
		setSize(200, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				try {
					serverSocketChannel.close();
					selector.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				} finally {
					System.exit(0);
				}
			}
		});
	}

	public void runServer() {
		try {
			charSet = Charset.forName("UTF-8");
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(12345));
			serverSocketChannel.configureBlocking(false);
			getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void getConnection() throws Exception {
		// TODO Auto-generated method stub
		selector = SelectorProvider.provider().openSelector();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, null);
		while (selector.select() > 0) {
			Set readKeys = selector.selectedKeys();
			Iterator iterator = readKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();
				iterator.remove();
				if (key.isAcceptable()) {
					ServerSocketChannel nextReady = (ServerSocketChannel) key.channel();
					SocketChannel socketChannel = nextReady.accept();
					if (socketChannel != null) {
						socketChannel.configureBlocking(false);
						sockets.add(socketChannel.socket());
						counter++;
						SwingUtilities.invokeLater(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								displayArea.append("\nConnection with Client " + counter);
							}
						});
						SelectionKey readKey = socketChannel.register(selector, SelectionKey.OP_READ, null);
					}
				} else if (key.isReadable()) {
					SocketChannel socketChannel = (SocketChannel) key.channel();
					readMessage(socketChannel);
				}
			}
		}
	}

	private void writeMessage(String message) throws IOException {
		Socket socket;
		SocketChannel socketChannel;
		for (int i = 0; i < sockets.size(); i++) {
			socket = (Socket) sockets.elementAt(i);
			socketChannel = socket.getChannel();
			try {
				writeBuffer = charSet.encode(message);
				socketChannel.write(writeBuffer);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				socketChannel.close();
				sockets.remove(socket);
			}
		}
	}

	private void readMessage(SocketChannel socketChannel) throws IOException {
		// TODO Auto-generated method stub
		try {
			if (socketChannel.isOpen()) {
				readBuffer.clear();
				socketChannel.read(readBuffer);
				readBuffer.flip();
				CharBuffer charMessage = charSet.decode(readBuffer);
				String message = charMessage.toString().trim();
				if (message.indexOf("Disconnect") >= 0) {
					sockets.remove(socketChannel.socket());
					socketChannel.close();
				} else {
					writeMessage(message);
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			sockets.remove(socketChannel.socket());
			socketChannel.close();
		}
	}

	public static void main(String[] args) {
		MessagerNonBlockingServer messagerNonBlockingServer = new MessagerNonBlockingServer();
		messagerNonBlockingServer.runServer();
	}
}
