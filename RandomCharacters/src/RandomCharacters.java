
//601
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class RandomCharacters extends JApplet implements ActionListener {

	private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static int SIZE = 3;
	private JLabel outputs[];
	private JCheckBox checkboxes[];
	private Thread threads[];
	private boolean suspended[];

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		outputs = new JLabel[SIZE];
		checkboxes = new JCheckBox[SIZE];
		threads = new Thread[SIZE];
		suspended = new boolean[SIZE];
		Container container = getContentPane();
		container.setLayout(new GridLayout(SIZE, 2, 5, 5));
		for (int count = 0; count < SIZE; count++) {
			outputs[count] = new JLabel();
			outputs[count].setBackground(Color.GREEN);
			outputs[count].setOpaque(true);
			container.add(outputs[count]);
			checkboxes[count] = new JCheckBox("Suspended");
			checkboxes[count].addActionListener(this);
			container.add(checkboxes[count]);
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
		for (int count = 0; count < threads.length; count++) {
			threads[count] = new Thread(new RunnableObject(), "Thread " + (count + 1));
			threads[count].start();
		}
	}

	private int getIndex(Thread current) {
		// TODO Auto-generated method stub
		for (int count = 0; count < threads.length; count++) {
			if (threads[count] == current) {
				return count;
			}
		}
		return -1;
	}

	public synchronized void stop() {
		for (int count = 0; count < threads.length; count++) {
			threads[count] = null;
		}
		notifyAll();
	}

	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int count = 0; count < checkboxes.length; count++) {
			if (e.getSource() == checkboxes[count]) {
				suspended[count] = !suspended[count];
				outputs[count].setBackground(suspended[count] ? Color.RED : Color.GREEN);
				if (!suspended[count])
					notifyAll();
				return;
			}
		}
	}

	public class RunnableObject implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			final Thread currentThread = Thread.currentThread();
			final int index = getIndex(currentThread);
			while (threads[index] == currentThread) {
				try {
					Thread.sleep((int) (Math.random() * 1000));
					synchronized (RandomCharacters.this) {
						while (suspended[index] && threads[index] == currentThread) {
							RandomCharacters.this.wait();
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						char displayChar = alphabet.charAt((int) (Math.random() * 26));
						outputs[index].setText(currentThread.getName() + ": " + displayChar);
					}
				});
			}
			System.out.println(currentThread.getName() + " terminating");
		}

	}
}
