
//P500
import java.awt.Graphics;

import javax.swing.JPanel;

public class CustomPanel extends JPanel {
	public final static int CIRCLE = 1, SQUARE = 2;
	private int shape;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (shape == CIRCLE)
			g.fillOval(50, 10, 60, 60);
		if (shape == SQUARE)
			g.fillRect(50, 10, 60, 60);
	}

	public void draw(int shapeToDraw) {
		shape = shapeToDraw;
		repaint();
	}
}
