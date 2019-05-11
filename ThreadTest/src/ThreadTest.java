
//P577 
import java.util.concurrent.TimeUnit;

public class ThreadTest {
	public static void main(String[] args) {
		PrintThread thread1 = new PrintThread("thread1");
		PrintThread thread2 = new PrintThread("thread2");
		PrintThread thread3 = new PrintThread("thread3");

		System.err.println(System.currentTimeMillis() + " " + "Start threads");
		thread1.start();
		thread2.start();
		thread3.start();
		System.err.println(System.currentTimeMillis() + " " + "Threads started, main ends");
	}
}

class PrintThread extends Thread {
	private int sleepTime;

	private static void delay1() {
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public PrintThread(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		delay1();
		sleepTime = (int) (Math.random() * 5001);
	}

	public void run() {
		try {
			System.err.println(System.currentTimeMillis() + " " + getName() + " going to sleep for " + sleepTime);
			Thread.sleep(sleepTime);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}