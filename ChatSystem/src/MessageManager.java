
public interface MessageManager {
	public void connect(MessageListener listener);

	public void disconnect(MessageListener listener);

	public void sendMessage(String from, String message);
}
