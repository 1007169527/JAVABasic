//P585
public class SynchronizedBuffer implements Buffer {
	private int buffer = -1;
	private int occupiedBufferCount = 0;

	public SynchronizedBuffer() {
		// TODO Auto-generated constructor stub
		System.out.println("In constructor stub for SynchronizedBuffer");
	}

	@Override
	public synchronized void set(int value) {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (occupiedBufferCount == 1) {
			try {
				System.out.println(name + " tries to write.");
				displayState("Buffer full. " + name + " waits.");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		buffer = value;
		++occupiedBufferCount;
		displayState(name + " writes " + buffer);
		notify();
	}

	@Override
	public synchronized int get() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (occupiedBufferCount == 0) {
			try {
				System.out.println(name + " tries to read.");
				displayState("Buffer empty. " + name + " waits.");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		--occupiedBufferCount;
		displayState(name + " reads " + buffer);
		notify();
		return buffer;
	}

	public void displayState(String operation) {
		StringBuffer outputLine = new StringBuffer(operation);
		outputLine.setLength(40);
		outputLine.append(buffer + "\t\t" + occupiedBufferCount);
		System.out.println(outputLine + "\n");
	}

}
