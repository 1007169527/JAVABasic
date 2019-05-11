//P581
public class Producer extends Thread {
	private Buffer sharedLocation;

	public Producer(Buffer shared) {
		super("Producer");
		sharedLocation = shared;
		if (shared == sharedLocation)
			System.err.println(shared.getClass() + " == " + sharedLocation.getClass());
	}

	public void run() {
		for (int count = 1; count <= 4; count++) {
			try {
				Thread.sleep((int) (Math.random() * 3001));
				sharedLocation.set(count);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.err.println(getName() + " done producing." + "\nTerminating " + getName() + ".");
	}
}
