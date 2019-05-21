import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	private JTextField enterField;
	private JTextArea displayArea;
	private DatagramSocket socket;

	public Client() {
		// TODO Auto-generated constructor stub
		super("Client");
		Container container = getContentPane();
		enterField = new JTextField("Type message here");
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				try {
					displayArea.append("\nSending packet containing: " + event.getActionCommand() + "\n");
					String message = event.getActionCommand();
					byte data[] = message.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 5000);
					socket.send(sendPacket);
					displayArea.append("Packet sent\n");
					displayArea.setCaretPosition(displayArea.getText().length());
				} catch (IOException e) {
					// TODO: handle exception
					displayMessage(e.toString() + "\n");
					e.printStackTrace();
				}
			}
		});

		container.add(enterField, BorderLayout.SOUTH);
		displayArea = new JTextArea();
		container.add(new JScrollPane(displayArea), BorderLayout.CENTER);
		setSize(400, 300);
		setVisible(true);

		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}

	private void waitForPacket() {
		while (true) {
			try {
				byte data[] = new byte[100];
				DatagramPacket receivePacket = new DatagramPacket(data, data.length);
				socket.receive(receivePacket);
				displayMessage("\nPacket received:" + "\nFrom host: " + receivePacket.getAddress() + "\nHost port: "
						+ receivePacket.getPort() + "\nLength: " + receivePacket.getLength() + "\nContaining: "
						+ new String(receivePacket.getData(), 0, receivePacket.getLength()));
			} catch (IOException e) {
				// TODO: handle exception
				displayMessage(e.toString() + "\n");
				e.printStackTrace();
			}
		}
	}

	protected void displayMessage(String message) {
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
		Client application = new Client();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPacket();
	}

}
