
public class Messenger {
	private static MessageManager messageManager;

	public static void main(String[] args) {
		if (args.length == 0)
			messageManager = new SocketMessageManager("localhost");
		else
			messageManager = new SocketMessageManager(args[0]);
		ClientGUI clientGUI = new ClientGUI(messageManager);
		clientGUI.setSize(300, 400);
		clientGUI.setResizable(false);
		clientGUI.setVisible(true);
	}
}
