import java.util.concurrent.TimeUnit;

public class SharedBufferTestII {
	private static void delay() {
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SynchronizedBuffer sharedLocation = new SynchronizedBuffer();
		StringBuffer columnHeads = new StringBuffer("Operation");
		columnHeads.append("\t\t\t\tBuffer\t\tOccupied Count");
		System.out.println(columnHeads + "\n");

		Producer producer = new Producer(sharedLocation);
		Consumer consumer = new Consumer(sharedLocation);
		producer.start();
		consumer.start();

		while (true) {
			if (producer.getState() == Thread.State.TERMINATED && consumer.getState() == Thread.State.TERMINATED)
				break;
			delay();
		}
		sharedLocation.dumpLogs();
		System.out.println("main exit");
	}
}
