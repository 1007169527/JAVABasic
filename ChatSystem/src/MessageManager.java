
public interface MessageManager {
	public void connect(MessageListener listener);

	public void disconnct(MessageListener listener);

	public void sendMessage(String from, String message);
}
