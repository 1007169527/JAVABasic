import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;

public class ServerThread extends Thread {
	private Socket clientSocket;
	private BufferedReader socketBufferedReader = null;
	private BufferedWriter socketBufferedWriter = null;
	private BufferedWriter fileBufferedWriter = null;
	private String destFileName = null;

	public ServerThread(Socket clientSocket) {
		this.clientSocket = clientSocket;
		System.out.println("Enter ServerThread");
		try {
			socketBufferedReader = new BufferedReader(
					new InputStreamReader(this.clientSocket.getInputStream(), "UTF-8"));
			socketBufferedWriter = new BufferedWriter(
					new OutputStreamWriter(this.clientSocket.getOutputStream(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getFileMD5(File file) {
		if (!file.exists() || !file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

	private String getFileMD5(String filepath) {
		File file = new File(filepath);
		return getFileMD5(file);
	}

	public void run() {
		String line;
		while (true) {
			try {
				line = socketBufferedReader.readLine();
				if ((line == null) || line.equalsIgnoreCase("TRANSFORM_FINISH")) {
					System.out.println("now connection finish");
					// System.out.println(getFileMD5(destFileName));
					socketBufferedWriter.write(getFileMD5(destFileName) + "\r\n");
					socketBufferedWriter.flush();
					clientSocket.close();
					return;
				} else {
					// System.out.println("a new line from client: " + line);
					if (line.contains("RECOVERY_LOG_FILE-")) {
						destFileName = "C:\\Users\\10071\\Desktop\\tmp\\" + line;
						fileBufferedWriter = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(destFileName, false), "UTF-8"));
					} else {
						fileBufferedWriter.write(line + "\r\n");
						fileBufferedWriter.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
	}
}