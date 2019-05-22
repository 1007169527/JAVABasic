
//P685
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {
	private JTextField enterField;
	private JTextArea displayArea;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private String message;
	private String chatServer;
	private Socket client;

	public Client(String host) {
		// TODO Auto-generated constructor stub
		super("Client");
		chatServer = host;
		Container container = getContentPane();
		enterField = new JTextField();
		enterField.setEditable(false);
		enterField.setBackground(Color.lightGray);
		enterField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				sendData(arg0.getActionCommand());
				enterField.setText("");
			}
		});
		container.add(enterField, BorderLayout.SOUTH);
		displayArea = new JTextArea();
		container.add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(300, 150);
		setVisible(true);
	}

	private void runClient() {
		try {
			connectToServer();
			getStreams();
			processConnection();
		} catch (EOFException e) {
			System.out.println("Client terminated the connection");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void connectToServer() throws IOException {
		// TODO Auto-generated method stub
		displayMessage("Attempting connection\n");
		client = new Socket(InetAddress.getByName(chatServer), 12345);
		displayMessage("Connected to: " + client.getInetAddress().getHostAddress());
	}

	private void getStreams() throws IOException {
		// TODO Auto-generated method stub
		output = new ObjectOutputStream(client.getOutputStream());
		output.flush();
		input = new ObjectInputStream(client.getInputStream());
		displayMessage("\nGot I/O streams\n");
	}

	private void processConnection() throws IOException {
		// TODO Auto-generated method stub
		setTextFieldEditable(true);
		do {
			try {
				message = (String) input.readObject();
				displayMessage("\n" + message);
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				displayMessage("\nUnknow object type recevied");
			}
		} while (!message.equals("SERVER>>> TERMINATE"));
	}

	private void closeConnection() {
		// TODO Auto-generated method stub
		displayMessage("\nClosing connection");
		setTextFieldEditable(false);
		try {
			output.close();
			input.close();
			client.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void sendData(String message) {
		// TODO Auto-generated method stub
		try {
			output.writeObject("Client>>> " + message);
			output.flush();
			displayMessage("\nClient>>> " + message);
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
		Client application;
		if (args.length == 0)
			application = new Client("127.0.0.1");
		else
			application = new Client(args[0]);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.runClient();
	}
}
