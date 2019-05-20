
//P681
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	private int counter = 1;

	public Server() {
		// TODO Auto-generated constructor stub
		Container container = getContentPane();
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.setBackground(Color.lightGray);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sendData(e.getActionCommand());
				enterField.setText("");
			}
		});

		container.add(enterField, BorderLayout.SOUTH);
		displayArea = new JTextArea();
		container.add(new JScrollPane(displayArea));
		setSize(300, 150);
		setVisible(true);
	}

	public void runServer() {
		// TODO Auto-generated method stub
		try {
			server = new ServerSocket(12345, 100);
			while (true) {
				try {
					waitForConnection();
					getStreams();
					processConnection();
				} catch (EOFException e) {
					System.out.println("Server terminated connection");
				} finally {
					closeConnection();
					++counter;
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void waitForConnection() throws IOException {
		// TODO Auto-generated method stub
		displayMessage("Wait for connection\n");
		connection = server.accept();
		displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
	}

	private void getStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		displayMessage("\nGot I/O streams\n");
	}

	private void processConnection() throws IOException {
		// TODO Auto-generated method stub
		String message = "Connection successful";
		sendData(message);
		setTextFieldEditable(true);
		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				displayMessage("\nunkonw object type received");
			}
		} while (!message.equals("CLIENT>>> TERMINATE"));
	}

	private void closeConnection() {
		// TODO Auto-generated method stub
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false);
		try {
			output.close();
			input.close();
			connection.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void sendData(String message) {
		// TODO Auto-generated method stub
		try {
			output.writeObject("SERVER>>>> " + message);
			output.flush();
			displayMessage("\nSERVER>>>> " + message);
		} catch (IOException e) {
			// TODO: handle exception
			displayMessage("\nError writing object\n");
		}
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

	private void setTextFieldEditable(boolean editable) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				enterField.setEditable(editable);
			}
		});
	}

	public static void main(String[] args) {
		Server application = new Server();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runServer();
	}
}
