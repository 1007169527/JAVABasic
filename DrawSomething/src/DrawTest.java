import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class DrawTest extends JFrame {
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JButton Button4;
	private JButton Button5;
	private JPanel panel1;
	private JPanel panel2;

	public DrawTest() {
		super("Drawing Test");
		Button1 = new JButton("Test Draw LinesRectsOvals");
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P430
				Graphics g = getGraphics();
				g.clearRect(0, 0, 400, 350);
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
				g.clearRect(0, 0, 400, 350);
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
				g.clearRect(0, 0, 400, 350);
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
		Button4 = new JButton("Test 2D 1");
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P435
				Graphics g = getGraphics();
				Graphics2D g2d = (Graphics2D) g;
				g2d.clearRect(0, 0, 400, 350);
				g2d.setPaint(new GradientPaint(5, 30, Color.BLUE, 35, 100, Color.YELLOW, true));
				g2d.fill(new Ellipse2D.Double(5, 30, 65, 100));

				g2d.setPaint(Color.RED);
				g2d.setStroke(new BasicStroke(10.0f));
				g2d.draw(new Rectangle2D.Double(80, 30, 65, 100));

				BufferedImage bufferedImage = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
				Graphics2D gg = bufferedImage.createGraphics();
				gg.setColor(Color.YELLOW);
				gg.fillRect(0, 0, 10, 10);
				gg.setColor(Color.BLACK);
				gg.drawRect(1, 1, 6, 6);
				gg.setColor(Color.BLUE);
				gg.fillRect(1, 1, 3, 3);
				gg.setColor(Color.RED);
				gg.fillRect(4, 4, 3, 3);

				g2d.setPaint(new TexturePaint(bufferedImage, new Rectangle(10, 10)));
				g2d.fill(new RoundRectangle2D.Double(155, 30, 75, 100, 50, 50));

				g2d.setPaint(Color.BLACK);
				g2d.setStroke(new BasicStroke(6.0f));
				g2d.draw(new Arc2D.Double(240, 35, 70, 100, 0, 270, Arc2D.PIE));

				g2d.setPaint(Color.GREEN);
				g2d.draw(new Line2D.Double(395, 30, 320, 150));

				float dashes[] = { 10 };
				g2d.setPaint(Color.YELLOW);
				g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0));
				g2d.draw(new Line2D.Double(320, 30, 395, 150));
			}
		});
		Button5 = new JButton("Test 2D 2");
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// P438
				Graphics g = getGraphics();
				Graphics2D g2d = (Graphics2D) g;
				g2d.clearRect(0, 0, 400, 350);
				int xPoints[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
				int yPoints[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
				GeneralPath star = new GeneralPath();
				star.moveTo(xPoints[0], yPoints[0]);

				for (int count = 1; count < xPoints.length; count++) {
					star.lineTo(xPoints[count], yPoints[count]);
				}
				star.closePath();

				g2d.translate(200, 200);
				for (int count = 1; count <= xPoints.length * 2; count++) {
					g2d.rotate(Math.PI / 10.0);
					g2d.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256),
							(int) (Math.random() * 256)));
					g2d.fill(star);
				}
			}
		});
		Container container = getContentPane();
		SpringLayout layout = new SpringLayout();
		container.setLayout(layout);
		panel1 = new JPanel();
		panel1.add(Button1);
		panel1.add(Button2);
		panel1.add(Button3);
		container.add(panel1);
		layout.putConstraint(SpringLayout.SOUTH, panel1, -40, SpringLayout.SOUTH, container);
		layout.putConstraint(SpringLayout.WEST, panel1, 0, SpringLayout.WEST, container);
		panel2 = new JPanel();
		panel2.add(Button4);
		panel2.add(Button5);
		container.add(panel2);
		layout.putConstraint(SpringLayout.SOUTH, panel2, -5, SpringLayout.SOUTH, container);
		layout.putConstraint(SpringLayout.WEST, panel2, 0, SpringLayout.WEST, container);
		setSize(495, 450);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String args[]) {
		DrawTest application = new DrawTest();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
