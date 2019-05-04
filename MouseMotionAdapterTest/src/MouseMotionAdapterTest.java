import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionAdapterTest extends JFrame {
	private int pointCount;
	private Point points[] = new Point[1000];
	private JLabel tip;

	public MouseMotionAdapterTest() {
		super("Test MouseMotionAdapter");
		tip = new JLabel("Drag the mouse to draw");
		getContentPane().add(tip, BorderLayout.SOUTH);
		// P474
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				if (pointCount < points.length) {
					points[pointCount] = event.getPoint();
					pointCount++;
					tip.setText("Now drawing ~");
					repaint();
				}
			}
		});
		// P475
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				String msg = "clicked with ";
				if (event.isMetaDown())
					msg += "rigth mouse button";
				else if (event.isAltDown())
					msg += "middle mouse button";
				else
					msg += "left mouse button";
				tip.setText(msg);
				repaint();
			}
		});
		setSize(300, 150);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < points.length && points[i] != null; i++)
			g.fillOval(points[i].x, points[i].y, 4, 4);
	}

	public static void main(String args[]) {
		MouseMotionAdapterTest motionAdapterTest = new MouseMotionAdapterTest();
		motionAdapterTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
