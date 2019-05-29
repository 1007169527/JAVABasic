import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PictureLoop extends JPanel implements ActionListener {
	private final static String IMAGE_NAME = "loop";
	protected ImageIcon images[];
	private int totalImages = 4;
	private int currentImage = 0;
	private int animationDelay = 3000;
	private int width;
	private int height;
	private Timer animationTimer;

	public PictureLoop() {
		// TODO Auto-generated method stub
		images = new ImageIcon[totalImages];
		for (int count = 0; count < images.length; ++count) {
			images[count] = new ImageIcon(getClass().getResource("images/" + IMAGE_NAME + count + ".jpg"));
			if (images[count] == null) {
				System.out.println("new ImageIcon failed");
				System.exit(-1);
			}
		}
		width = images[0].getIconWidth();
		height = images[0].getIconHeight();
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		images[currentImage].paintIcon(this, g, 0, 0);
		if (animationTimer.isRunning()) {
			System.out.println("in paintComponent");
			currentImage = (currentImage + 1) % totalImages;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void startAnimation() {
		if (animationTimer == null) {
			currentImage = 0;
			animationTimer = new Timer(animationDelay, this);
			animationTimer.start();
		} else if (!animationTimer.isRunning())
			animationTimer.restart();
	}

	public void stopAnimation() {
		animationTimer.stop();
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public static void main(String[] args) {
		PictureLoop loop = new PictureLoop();
		JFrame window = new JFrame("Animatior test");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = window.getContentPane();
		container.add(loop);
		window.pack();
		window.setVisible(true);
		loop.startAnimation();
	}
}
