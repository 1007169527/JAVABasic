//P582
public class SharedBufferTest {
	public static void main(String[] args) {
		tip();
		Buffer sharedLocation = new UnsynchronizedBuffer();
		Producer producer = new Producer(sharedLocation);
		Consumer consumer = new Consumer(sharedLocation);
		producer.start();
		consumer.start();
	}

	private static void tip() {
		ClassTest c1 = new ClassTest();
		ClassTest c2 = new ClassTest();
		ClassTest c3 = c1;
		c1.set(3);
		if (c1 == c2)
			System.err.println("c1 == c2");
		else
			System.err.println("c1 != c2");
		if (c3 == c1)
			System.err.println("c3 == c1");
		else
			System.err.println("c3 != c1");
		System.err.println("After c1.set(3), c3.get() returns " + c3.get());
	}
}

class ClassTest {
	private int num;

	public int get() {
		return num;
	}

	public void set(int n) {
		num = n;
	}
}
