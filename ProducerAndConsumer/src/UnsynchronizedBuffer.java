//P582
public class UnsynchronizedBuffer implements Buffer {
	private int buffer = -1;

	@Override
	public void set(int value) {
		// TODO Auto-generated method stub
		System.err.println(Thread.currentThread().getName() + " write " + value);
		buffer = value;
	}

	@Override
	public int get() {
		// TODO Auto-generated method stub
		System.err.println(Thread.currentThread().getName() + " reads " + buffer);
		return buffer;
	}

}
