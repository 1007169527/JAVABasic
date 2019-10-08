import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientThread extends Thread {
	protected Socket clientSocket;
	private BufferedReader socketBufferedReader = null;
	private BufferedWriter socketBufferedWriter = null;
	private BufferedReader fileBufferedReader = null;
	private BufferedWriter fileBufferedWriter = null;
	private int count = 0;

	private String logFileFullPath = "";
	private String pcName = "";

	public ClientThread(Socket clientSocket, String logFileFullPath, String pcName) {
		this.clientSocket = clientSocket;
		try {
			socketBufferedWriter = new BufferedWriter(
					new OutputStreamWriter(this.clientSocket.getOutputStream(), "UTF-8"));
			socketBufferedReader = new BufferedReader(
					new InputStreamReader(this.clientSocket.getInputStream(), "UTF-8"));
			fileBufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFileFullPath), "UTF-8"));
			fileBufferedWriter = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("C:\\Users\\10071\\Desktop\\tmp\\dest1-20191008-095928.log", false), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.logFileFullPath = logFileFullPath;
		this.pcName = pcName;
		System.out.println("a new client thread init finished");
	}

	private void uploadLogFile() {
		byte[] buf = new byte[4096];
		String line;
		try {
			// socketBufferedWriter.write("LogFileFullPath=" + logFileFullPath + "\n\r");
			// socketBufferedWriter.write("PCName=" + pcName + "\n\r");

			line = fileBufferedReader.readLine();
			while (line != null) {
				System.out.println("a new line from src: " + line);
				socketBufferedWriter.write(line + "\n");
				socketBufferedWriter.flush();
				fileBufferedWriter.write(line + "\r\n");
				fileBufferedWriter.flush();
				line = fileBufferedReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileBufferedReader.close();
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void checkServerMsg() {
		String message = "";
		do {
			try {
				message = socketBufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!message.equals("SERVER>>> MD5 CHECK PASS"));
	}

	public void run() {
		uploadLogFile();
		// checkServerMsg();
		return;
	}
}