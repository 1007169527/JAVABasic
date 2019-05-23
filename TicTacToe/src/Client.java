
//P700
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JApplet implements Runnable {
	private JTextField idField;
	private JTextArea displayArea;
	private JPanel boardPanel, panel2;
	private Square board[][], currentSquare;
	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private char myMark;
	private boolean myTurn;
	private final char X_MARK = 'X', O_MARK = 'O';

	public void init() {
		Container container = getContentPane();
		displayArea = new JTextArea(4, 30);
		displayArea.setEditable(false);
		container.add(new JScrollPane(displayArea), BorderLayout.SOUTH);
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(3, 3, 0, 0));
		board = new Square[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int colume = 0; colume < board[row].length; colume++) {
				board[row][colume] = new Square(' ', row * 3 + colume);
				boardPanel.add(board[row][colume]);
			}
		}
		idField = new JTextField();
		idField.setEditable(false);
		container.add(idField, BorderLayout.NORTH);
		panel2 = new JPanel();
		panel2.add(boardPanel, BorderLayout.CENTER);
		container.add(panel2, BorderLayout.CENTER);
	}

	public void start() {
		// TODO Auto-generated method stub
		try {
			connection = new Socket(InetAddress.getLocalHost(), 12345);
			input = new DataInputStream(connection.getInputStream());
			output = new DataOutputStream(connection.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Thread outputThread = new Thread(this);
		outputThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			myMark = input.readChar();
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					idField.setText("You are player \"" + myMark + "\"");
				}
			});
			myTurn = (myMark == X_MARK ? true : false);
			while (true) {
				processMessage(input.readUTF());
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void processMessage(String message) {
		if (message.equals("Valid move.")) {
			displayMessage("Valid move, please wait.\n");
			setMark(currentSquare, myMark);
		} else if (message.equals("Invalid move, try again")) {
			displayMessage(message + "\n");
			myTurn = true;
		} else if (message.equals("Opponent move, try again")) {
			try {
				int location = input.readInt();
				int row = location / 3;
				int colume = location % 3;
				setMark(board[row][colume], (myMark == X_MARK ? O_MARK : X_MARK));
				displayMessage("Opponent moved. Your turn.\n");
				myTurn = true;
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			displayMessage(message);
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

	private void setMark(Square squareToMark, char mark) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				squareToMark.setMark(mark);
			}
		});
	}

	public void sendClickedSquare(int location) {
		if (myTurn) {
			try {
				output.writeInt(location);
				myTurn = false;
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void setCurrentSquare(Square square) {
		currentSquare = square;
	}

	private class Square extends JPanel {
		private char mark;
		private int location;

		public Square(char squareMark, int squareLocation) {
			// TODO Auto-generated constructor stub
			location = squareLocation;
			mark = squareMark;
			addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					setCurrentSquare(Square.this);
					sendClickedSquare(getSquareLocation());
				}
			});
		}

		public Dimension getPreferredSize() {
			return new Dimension(30, 30);
		}

		public Dimension getMinmumDimension() {
			return getPreferredSize();
		}

		public void setMark(char newMark) {
			// TODO Auto-generated method stub
			mark = newMark;
			repaint();
		}

		public int getSquareLocation() {
			return location;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(0, 0, 29, 29);
			g.drawString(String.valueOf(mark), 11, 20);
		}
	}
}
