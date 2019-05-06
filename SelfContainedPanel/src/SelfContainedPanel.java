
//502
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class SelfContainedPanel extends JPanel {
	private int x1, x2, y1, y2;

	public SelfContainedPanel() {
		// TODO Auto-generated constructor stub
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				x1 = event.getX();
				y1 = event.getY();
			}

			public void mouseReleased(MouseEvent event) {
				x2 = event.getX();
				y2 = event.getY();
				repaint();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				x2 = event.getX();
				y2 = event.getY();
				repaint();
			}
		});
	}

	public Dimension getPreferredSize() {
		return new Dimension(150, 100);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
	}
}
