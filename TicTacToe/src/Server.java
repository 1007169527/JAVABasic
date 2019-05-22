import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private char[] board;
	private JTextArea outputArea;
	private Player[] players;
	private ServerSocket server;
	private int currentPlayer;
	private final int PLAYER_X = 0, PLAYER_O = 1;
	private final char X_MARK = 'x', O_MARK = 'o';

	public Server() {
		// TODO Auto-generated constructor stub
		super("TicTacToe");
		board = new char[9];
		players = new Player[2];
		currentPlayer = PLAYER_X;

		try {
			server = new ServerSocket(12345, 2);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}

		outputArea = new JTextArea();
		getContentPane().add(outputArea, BorderLayout.CENTER);
		outputArea.setText("Server awaiting connections\n");

		setSize(300, 300);
		setVisible(true);
	}

	public void execute() {
		for (int i = 0; i < players.length; i++) {
			try {
				players[i] = new Player(server.accept(), i);
				players[i].start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.exit(1);
			}
		}

		synchronized (players[PLAYER_X]) {
			players[PLAYER_X].setSuspend(false);
			players[PLAYER_X].notify();
		}
	}

	private void displayMessage(String message) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				outputArea.append(message);
				outputArea.setCaretPosition(outputArea.getText().length());
			}
		});
	}

	public synchronized boolean validateAndMove(int location, int player) {
		boolean moveDone = false;
		while (player != currentPlayer) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (!isOccupied(location)) {
			board[location] = currentPlayer == PLAYER_X ? X_MARK : O_MARK;
			currentPlayer = (currentPlayer + 1) % 2;
			players[currentPlayer].otherPlayerMoved(location);
			notify();
			return true;
		} else
			return false;
	}

	public boolean isOccupied(int location) {
		// TODO Auto-generated method stub
		if (board[location] == X_MARK || board[location] == O_MARK)
			return true;
		else
			return false;
	}

	public boolean isGameOver() {
		return false;
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.execute();
	}

	private class Player extends Thread {
		private Socket connection;
		private DataInputStream input;
		private DataOutputStream output;
		private int playerNumber;
		private char mark;
		protected boolean suspended = true;

		public Player(Socket socket, int number) {
			// TODO Auto-generated constructor stub
			playerNumber = number;
			mark = (playerNumber == PLAYER_X ? X_MARK : O_MARK);
			connection = socket;
			try {
				input = new DataInputStream(connection.getInputStream());
				output = new DataOutputStream(connection.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		public void otherPlayerMoved(int location) {
			// TODO Auto-generated method stub
			try {
				output.writeUTF("Opponent moved");
				output.writeInt(location);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		public void run() {
			try {
				displayMessage("Player " + (playerNumber == PLAYER_X ? "X connected\n" : "O connected, please wait\n"));
				output.writeChar(mark);
				output.writeUTF(
						"Player " + (playerNumber == PLAYER_X ? "X connected\n" : "O connected, please wait\n"));
				if (mark == X_MARK) {
					output.writeUTF("Waiting for another player");
					try {
						synchronized (this) {
							while (suspended)
								wait();
						}
					} catch (InterruptedException e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					output.writeUTF("Other player connected. Your move");
				}

				while (!isGameOver()) {
					int location = input.readInt();
					if (validateAndMove(location, playerNumber)) {
						displayMessage("\nlocation: " + location);
						output.writeUTF("Invalid move.");
					} else
						output.writeUTF("Invalid move,try again");
				}
				connection.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
				System.exit(1);
			}
		}

		public void setSuspend(boolean status) {
			// TODO Auto-generated method stub
			suspended = status;
		}
	}
}
