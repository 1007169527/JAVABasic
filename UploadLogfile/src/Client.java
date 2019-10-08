import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Client {
	private static Socket socket;
	private static String computerName;
	private String fileDir = "D:\\SecureCRT";
	private String logPassList = "D:\\.LogPassList";
	private String latestLogPath = "";
	private String secondLatestLogFullPath = "";
	private BufferedReader fileBufferedReader = null;
	private BufferedWriter fileBufferedWriter = null;
	private StringBuffer logPassFileStringBuffer = new StringBuffer();
	private String[] logFiles;
	private int loopCount = 0;

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

	private void readPassList() {
		File file = new File(logPassList);
		String line;
		if (file.exists() == false)
			return;
		try {
			fileBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(logPassList), "UTF-8"));
			line = fileBufferedReader.readLine();
			while (line != null) {
				logPassFileStringBuffer.append(line + "\r\n");
				line = fileBufferedReader.readLine();
			}
			fileBufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("logPassFileStringBuffer is " +
		// logPassFileStringBuffer.toString());
	}

	private boolean isInPassList(String fileName) {
		return logPassFileStringBuffer.toString().contains(fileName);
	}

	private String loopLogFiles() {
		String tmpString;
		for (; loopCount <= logFiles.length - 1; loopCount++) {
			tmpString = logFiles[loopCount];
			// System.out.println("tmpString is " + tmpString);
			if (tmpString.equals("PassList") || tmpString.equals(latestLogPath) || isInPassList(tmpString))
				continue;
			else
				return fileDir + "\\" + logFiles[loopCount];
		}
		return "";
	}

	private void matchLatestLogFile() {
		long latestModifiedTime = 0;
		File file = new File(fileDir);
		if (file == null) {
			// System.out.println("new File failed");
			return;
		}
		logFiles = file.list();
		if (logFiles == null) {
			// System.out.println("file.list() return null");
			return;
		}
		// System.out.println("files.length = " + files.length);
		for (int i = 0; i < logFiles.length; i++) {
			// System.out.println("we got " + files[i]);
			File f = new File(fileDir + "/" + logFiles[i]);
			if (f.isFile()) {
				if (logFiles[i].equals("PassList")) {
					continue;
				} else {
					if (latestModifiedTime <= f.lastModified()) {
						latestModifiedTime = f.lastModified();
						latestLogPath = logFiles[i];
					}
				}
			}
		}
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
		String logFileFullPath = "";
		client.readPassList();
		client.matchLatestLogFile();
		logFileFullPath = client.loopLogFiles();
		// System.out.print("PCName=" + computerName + "\n\r");
		// System.out.print("LogFileFullPath=" + logFileFullPath + "\n\r");
		sleepSeconds(3);
		if ("".equals(logFileFullPath) == false)
			new ClientThread(socket, logFileFullPath, computerName).start();
		else
			sleepSeconds(5);
	}
}
