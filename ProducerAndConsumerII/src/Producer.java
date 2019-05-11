//P581
public class Producer extends Thread {
	private Buffer sharedLocation;

	public Producer(Buffer shared) {
		super("Producer");
		sharedLocation = shared;
		// if (shared == sharedLocation)
		// System.out.println(shared.getClass() + " == " + sharedLocation.getClass());
	}

	public void run() {
		for (int count = 1; count <= 4; count++) {
			try {
				Thread.sleep((int) (3000));
				sharedLocation.set(count);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println(getName() + " done producing." + "\nTerminating " + getName() + ".");
	}
}
