import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ClientThread extends Thread {
	protected Socket clientSocket;
	private BufferedReader socketBufferedReader = null;
	private BufferedWriter socketBufferedWriter = null;
	private BufferedReader fileBufferedReader = null;
	private BufferedWriter fileBufferedWriter = null;
	private StringBuffer logStringBuffer = new StringBuffer();
	private String[] enterRecoveryStringBuffer = { "will_enter_recovery = 1", "BROWSER_LABEL_COUNT" };
	private String[] exitRecoveryStringBuffer = { "", "" };
	private int count = 0;
	private boolean validLog = false;
	private String logFileFullPath = "";
	private String pcName = "";
	private String logPassList = "D:\\.LogPassList";
	private String logFileName = "";

	public ClientThread(Socket clientSocket, String logFileFullPath, String pcName) {
		this.clientSocket = clientSocket;
		try {
			socketBufferedWriter = new BufferedWriter(
					new OutputStreamWriter(this.clientSocket.getOutputStream(), "UTF-8"));
			socketBufferedReader = new BufferedReader(
					new InputStreamReader(this.clientSocket.getInputStream(), "UTF-8"));
			fileBufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(logFileFullPath), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.logFileFullPath = logFileFullPath;
		this.pcName = pcName;
		System.out.println("a new client thread init finished");
	}

	private void readLogFile() {
		String line;
		validLog = false;
		try {
			line = fileBufferedReader.readLine();
			while (line != null) {
				// System.out.println("a new line from src: " + line);
				logStringBuffer.append(line + "\r\n");
				if (validLog == false) {
					for (int count = 0; count <= enterRecoveryStringBuffer.length - 1; count++) {
						if (line.contains(enterRecoveryStringBuffer[count]))
							validLog = true;
					}
				}
				line = fileBufferedReader.readLine();
			}
			fileBufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void uploadLogFile() {
		try {
			int index1 = logFileFullPath.lastIndexOf("/");
			int index2 = logFileFullPath.lastIndexOf("\\");
			if (index1 >= index2)
				logFileName = logFileFullPath.substring(index1 + 1);
			else
				logFileName = logFileFullPath.substring(index2 + 1);
			socketBufferedWriter.write("RECOVERY_LOG_FILE-" + pcName.toUpperCase() + "-" + logFileName + "\n");
			if (validLog == false) {
				System.out.println("This log is not valid !");
			} else {
				socketBufferedWriter.write(logStringBuffer.toString());
				socketBufferedWriter.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
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

	private void updateLogPassList() {
		try {
			fileBufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(logPassList, true), "UTF-8"));
			fileBufferedWriter.write(logFileName + "\r\n");
			fileBufferedWriter.flush();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		readLogFile();
		uploadLogFile();
		// checkServerMsg();
		updateLogPassList();
		return;
	}
}