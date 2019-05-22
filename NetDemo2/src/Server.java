
//P690
import java.awt.BorderLayout;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private JTextArea displayArea;
	private DatagramSocket socket;

	public Server() {
		// TODO Auto-generated constructor stub
		super("Server");
		displayArea = new JTextArea();
		getContentPane().add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);
		try {
			socket = new DatagramSocket(5000);
		} catch (SocketException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void waitForPackets() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				byte data[] = new byte[100];
				DatagramPacket receivePacket = new DatagramPacket(data, data.length);
				socket.receive(receivePacket);
				displayMessage("\nPacket received:" + "\nFrom host: " + receivePacket.getAddress() + "\nLength: "
						+ receivePacket.getLength() + "\nContaining: "
						+ new String(receivePacket.getData(), 0, receivePacket.getLength()));
				sendPacketToClient(receivePacket);
			} catch (IOException e) {
				// TODO: handle exception
				displayMessage(e.toString() + "\n");
				e.printStackTrace();
			}
		}
	}

	private void sendPacketToClient(DatagramPacket receivePacket) throws IOException {
		// TODO Auto-generated method stub
		displayMessage("\nEcho data to client ...");
		DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),
				receivePacket.getAddress(), receivePacket.getPort());
		socket.send(sendPacket);
		displayMessage("Packet sent\n");
	}

	private void displayMessage(String message) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				displayArea.append(message);
				displayArea.setCaretPosition(displayArea.getText().length());
			}
		});
	}

	public static void main(String[] args) {
		Server application = new Server();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();
	}
}
