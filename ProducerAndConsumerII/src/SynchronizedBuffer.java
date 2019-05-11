//P585
public class SynchronizedBuffer implements Buffer {
	private int buffer = -1;
	private int occupiedBufferCount = 0;
	private StringBuffer outputLine = new StringBuffer();

	public SynchronizedBuffer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized void set(int value) {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (occupiedBufferCount == 1) {
			try {
				System.out.println(name + " tries to write.");
				// displayState("Buffer full. " + name + " waits.");
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
				// displayState("Buffer empty. " + name + " waits.");
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
		outputLine.append("\n" + operation + "\t\t\t");
		outputLine.append(buffer + "\t\t" + occupiedBufferCount);
		// System.out.println(outputLine + "\n");
	}

	public void dumpLogs() {
		System.out.println(outputLine);
	}
}
