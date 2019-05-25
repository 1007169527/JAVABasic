import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

public class ClientGUI extends JFrame {
	private JMenu serverMenu;
	private JTextArea messageArea;
	private JTextArea inputArea;
	private JButton connectButton;
	private JMenuItem connectMenuItem;
	private JButton disconnectButton;
	private JMenuItem disconnectMenuItem;
	private JButton sendButton;
	private JLabel statusBar;
	private String userName;
	private MessageListener messageListener;
	private MessageManager messageManager;

	public ClientGUI(MessageManager manager) {
		// TODO Auto-generated constructor stub
		super("ClientGUI");
		messageManager = manager;
		messageListener = new MyMessageListener();
		serverMenu = new JMenu("Server");
		serverMenu.setMnemonic('S');
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(serverMenu);
		setJMenuBar(menuBar);
		Icon connectionIcon = new ImageIcon(getClass().getResource("images/Connect.gif"));
		connectButton = new JButton("Connect", connectionIcon);
		connectMenuItem = new JMenuItem("Connect", connectionIcon);
		connectMenuItem.setMnemonic('C');
		ActionListener connectListener = new ConnectListener();
		connectMenuItem.addActionListener(connectListener);
		Icon disconnectIcon = new ImageIcon(getClass().getResource("images/Disconnect.gif"));
		disconnectButton = new JButton("Disconnect", disconnectIcon);
		disconnectMenuItem = new JMenuItem("Disconnect", disconnectIcon);
		disconnectMenuItem.setMnemonic('D');
		disconnectButton.setEnabled(false);
		disconnectMenuItem.setEnabled(false);
		ActionListener disconnectListener = new DisconnectListener();
		disconnectMenuItem.addActionListener(disconnectListener);
		serverMenu.add(connectMenuItem);
		serverMenu.add(disconnectMenuItem);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(connectButton);
		buttonPanel.add(disconnectButton);
		messageArea = new JTextArea();
		messageArea.setEditable(false);
		messageArea.setWrapStyleWord(true);
		messageArea.setLineWrap(true);
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BorderLayout(10, 10));
		messagePanel.add(new JScrollPane(messageArea), BorderLayout.CENTER);
		inputArea = new JTextArea(4, 20);
		inputArea.setWrapStyleWord(true);
		inputArea.setLineWrap(true);
		inputArea.setEditable(false);
		Icon sendIcon = new ImageIcon(getClass().getResource("images/Send.gif"));
		sendButton = new JButton("Send", sendIcon);
		sendButton.setEnabled(false);
		sendButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				messageManager.sendMessage(userName, inputArea.getText());
				inputArea.setText("");
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(inputArea));
		box.add(sendButton);
		messagePanel.add(box, BorderLayout.SOUTH);
		statusBar = new JLabel("Not connected");
		statusBar.setBorder(new BevelBorder(BevelBorder.LOWERED));
		Container container = getContentPane();
		container.add(buttonPanel, BorderLayout.NORTH);
		container.add(messagePanel, BorderLayout.CENTER);
		container.add(statusBar, BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				messageManager.disconnect(messageListener);
				System.exit(0);
			}
		});
	}

	private class ConnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			messageManager.connect(messageListener);
			userName = JOptionPane.showInputDialog(ClientGUI.this, "Enter user name:");
			messageArea.setText("");
			connectButton.setEnabled(false);
			connectMenuItem.setEnabled(false);
			disconnectButton.setEnabled(true);
			disconnectMenuItem.setEnabled(true);
			inputArea.setEditable(true);
			inputArea.requestFocus();
			statusBar.setText("Connected: " + userName);
		}

	}

	private class DisconnectListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			messageManager.disconnect(messageListener);
			sendButton.setEnabled(false);
			disconnectButton.setEnabled(false);
			disconnectMenuItem.setEnabled(false);
			inputArea.setEditable(false);
			connectButton.setEnabled(true);
			connectMenuItem.setEnabled(true);
			statusBar.setText("Not connected");
		}

	}

	private class MyMessageListener implements MessageListener {

		@Override
		public void messageReceived(String from, String message) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new MessageDisplayer(from, message));
		}

	}

	private class MessageDisplayer implements Runnable {
		private String fromUser;
		private String messageBody;

		public MessageDisplayer(String from, String message) {
			// TODO Auto-generated constructor stub
			fromUser = from;
			messageBody = message;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			messageArea.append("\n" + fromUser + "> " + messageBody);
			messageArea.setCaretPosition(messageArea.getText().length());
		}
	}
}
