import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {
	private static Socket socket;
	private static String computerName;

	public Client() {
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 1992);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> map = System.getenv();
		computerName = map.get("COMPUTERNAME");
	}

	private String lockLogFile() {
		File logFile;
		return "";
	}

	private static void sleepSeconds(int count) {
		try {
			TimeUnit.SECONDS.sleep(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Client client = new Client();
		String logFileFullPath = "C:\\Users\\10071\\Desktop\\tmp\\src";
		// while (true) {
		// logFileFullPath = client.lockLogFile();
		if ("".equals(logFileFullPath) == false)
			new ClientThread(socket, logFileFullPath, computerName).start();
		else
			sleepSeconds(5);
		// }
	}
}
