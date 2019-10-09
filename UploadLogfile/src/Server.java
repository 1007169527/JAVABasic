import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {
	private static final int PORT = 1992;

	private static void sleepSeconds(int count) {
		try {
			TimeUnit.SECONDS.sleep(count);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(PORT, 100);
			System.out.println("Finish init ServerSocket");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (true) {
			try {
				System.out.println("Wait for connection\n");
				socket = serverSocket.accept();
				System.out.println("a new client connection established");
				new ServerThread(socket).start();
				// serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}