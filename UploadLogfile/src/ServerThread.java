import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket clientSocket;
	private BufferedReader socketBufferedReader = null;
	private BufferedWriter socketBufferedWriter = null;
	private BufferedWriter fileBufferedWriter = null;

	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		System.out.println("Enter ServerThread");
		try {
			socketBufferedReader = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
			socketBufferedWriter = new BufferedWriter(new OutputStreamWriter(this.clientSocket.getOutputStream()));
			fileBufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\10071\\Desktop\\tmp\\dest"));
		} catch (IOException e) {
			return;
		}
	}

	public void run() {
		byte[] buf = new byte[4096];
		String line;
		while (true) {
			try {
				line = socketBufferedReader.readLine();
				if ((line == null) || line.equalsIgnoreCase("QUIT")) {
					System.out.println("now connection finish");
					// socketBufferedWriter.write("");
					clientSocket.close();
					return;
				} else {
					System.out.println("a new line from client: " + line);
					fileBufferedWriter.write(line + "\n");
					fileBufferedWriter.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}