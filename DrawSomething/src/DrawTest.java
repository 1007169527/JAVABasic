import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class DrawTest extends JFrame {
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JPanel panel;

	public DrawTest() {
		super("Drawing Test");
		Button1 = new JButton("Test Draw LinesRectsOvals");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P430
				Graphics g = getGraphics();
				g.clearRect(0, 0, 400, 300);
				g.setColor(Color.RED);
				g.drawLine(50, 30, 350, 30);
				g.setColor(Color.BLUE);
				g.drawRect(5, 40, 90, 55);
				g.fillRect(100, 40, 90, 55);

				g.setColor(Color.CYAN);
				g.fillRoundRect(195, 40, 90, 55, 50, 50);
				g.drawRoundRect(290, 40, 90, 55, 20, 20);

				g.setColor(Color.YELLOW);
				g.draw3DRect(5, 100, 90, 55, true);
				g.fill3DRect(100, 100, 90, 55, true);

				g.setColor(Color.MAGENTA);
				g.drawOval(195, 100, 90, 55);
				g.fillOval(290, 100, 90, 55);
			}
		});
		Button2 = new JButton("Test Draw Arcs");
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P432
				Graphics g = getGraphics();
				g.clearRect(0, 0, 400, 300);
				g.setColor(Color.YELLOW);
				g.drawRect(15, 35, 80, 80);
				g.setColor(Color.BLACK);
				g.drawArc(15, 35, 80, 80, 0, 360);

				g.setColor(Color.YELLOW);
				g.drawRect(100, 35, 80, 80);
				g.setColor(Color.BLACK);
				g.drawArc(100, 35, 80, 80, 0, 110);

				g.setColor(Color.YELLOW);
				g.drawRect(180, 35, 80, 80);
				g.setColor(Color.BLACK);
				g.drawArc(185, 35, 80, 80, 0, -270);

				g.fillArc(15, 120, 80, 40, 0, 360);

				g.fillArc(100, 120, 80, 40, 270, -90);

				g.fillArc(185, 120, 80, 40, 0, -270);
			}
		});
		Button3 = new JButton("Test Draw Polygons");
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P433
				int xValue[] = { 20, 40, 50, 30, 20, 15 };
				int yValue[] = { 50, 50, 60, 80, 80, 60 };
				Graphics g = getGraphics();
				g.clearRect(0, 0, 400, 300);
				Polygon polygon1 = new Polygon(xValue, yValue, 6);
				g.drawPolygon(polygon1);

				int xValue2[] = { 70, 90, 100, 80, 70, 65, 60 };
				int yValue2[] = { 100, 100, 110, 110, 130, 110, 90 };
				g.drawPolyline(xValue2, yValue2, 7);

				int xValue3[] = { 120, 140, 150, 190 };
				int yValue3[] = { 40, 70, 80, 60 };
				g.fillPolygon(xValue3, yValue3, 4);

				Polygon polygon2 = new Polygon();
				polygon2.addPoint(165, 135);
				polygon2.addPoint(175, 150);
				polygon2.addPoint(270, 200);
				polygon2.addPoint(200, 220);
				polygon2.addPoint(130, 180);

				g.fillPolygon(polygon2);
			}
		});
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		panel = new JPanel();
		panel.add(Button1);
		panel.add(Button2);
		panel.add(Button3);
		container.add(panel);
		layout.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, container);
		layout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, container);
		setSize(495, 400);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		DrawTest application = new DrawTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
