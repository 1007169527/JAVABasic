//gcp's demo
public class LogTest {
	public static void main(String args[]) {
		Log.err("this is an err msg;");
		Log.info("this is an info msg;");
		Log.debug("this is a debug msg;");
	}
}

class Log {
	private static final String errTag = "Error: GCP ";
	private static final String infoTag = "Info: GCP ";
	private static final String debugTag = "Debug: GCP ";
	
	public static void err(String msg) {
		System.out.println(errTag + msg);
	}
	
	public static void info(String msg) {
		System.out.println(infoTag + msg);
	}
	
	public static void debug(String msg) {
		System.out.println(debugTag + msg);
	}
}