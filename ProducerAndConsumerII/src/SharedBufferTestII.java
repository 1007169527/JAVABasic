
public class SharedBufferTestII {
	public static void main(String[] args) {
		SynchronizedBuffer sharedLocation = new SynchronizedBuffer();
		StringBuffer columnHeads = new StringBuffer("Operation");
		columnHeads.append("Buffer\t\tOccupied Count");
		System.out.println(columnHeads + "\n");
		sharedLocation.displayState("Initial State");

		Producer producer = new Producer(sharedLocation);
		Consumer consumer = new Consumer(sharedLocation);
		producer.start();
		consumer.start();
	}
}
