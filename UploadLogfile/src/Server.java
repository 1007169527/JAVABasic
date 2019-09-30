import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private static final int PORT = 1992;

	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(PORT, 10);
			System.out.println("Finish init ServerSocket");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// while (true) {
		try {
			System.out.println("Wait for connection\n");
			socket = serverSocket.accept();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("a new client connection established");
		new ServerThread(socket).start();
		// }
	}
}