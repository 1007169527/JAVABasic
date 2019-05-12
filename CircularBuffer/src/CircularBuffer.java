
//P593
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class CircularBuffer implements Buffer {
	private int buffers[] = { -1, -1, -1 };
	private int occupiedBufferCount = 0;
	private int readLocation = 0, writelocation = 0;
	private JTextArea outpuArea;

	public CircularBuffer(JTextArea output) {
		// TODO Auto-generated constructor stub
		outpuArea = output;
	}

	public synchronized void set(int value) {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (occupiedBufferCount == buffers.length) {
			try {
				SwingUtilities.invokeLater(new RunnableOutput(outpuArea, "\nAll Buffers full\n"));
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		buffers[writelocation] = value;
		SwingUtilities.invokeLater(new RunnableOutput(outpuArea, "\n" + name + " writes " + value + "\n"));
		++occupiedBufferCount;
		writelocation = (writelocation + 1) % buffers.length;
		SwingUtilities.invokeLater(new RunnableOutput(outpuArea, createStateOutput()));
		notify();
	}

	@Override
	public synchronized int get() {
		// TODO Auto-generated method stub
		String name = Thread.currentThread().getName();
		while (occupiedBufferCount == 0) {
			try {
				SwingUtilities.invokeLater(new RunnableOutput(outpuArea, "\nAll Buffers empty\n"));
				wait();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		int readValue = buffers[readLocation];
		buffers[readLocation] = -1;
		SwingUtilities.invokeLater(new RunnableOutput(outpuArea, "\n" + name + " reads " + readValue + "\n"));
		--occupiedBufferCount;
		readLocation = (readLocation + 1) % buffers.length;
		SwingUtilities.invokeLater(new RunnableOutput(outpuArea, createStateOutput()));
		notify();
		return readValue;
	}

	public String createStateOutput() {
		String output = "(buffers occupied: " + occupiedBufferCount + ")\nbuffers: ";
		for (int i = 0; i < buffers.length; i++) {
			output += " " + buffers[i] + " ";
		}
		output += "\n";
		for (int i = 0; i < buffers.length; i++)
			if (i == writelocation && writelocation == readLocation)
				output += " WR ";
			else if (i == readLocation)
				output += " R ";
			else if (i == writelocation)
				output += " W ";
			else
				output += "   ";
		output += "\n";
		return output;
		// TODO Auto-generated method stub

	}
}
