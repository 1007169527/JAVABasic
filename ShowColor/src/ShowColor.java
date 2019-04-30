
//P422
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class ShowColor extends JFrame {
	public ShowColor() {
		super("Using colors");
		setSize(400, 130);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(255, 0, 0));
		g.fillRect(25, 25, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 40);

		g.setColor(new Color(0.0f, 1.0f, 0.0f));
		g.fillRect(25, 50, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 65);

		g.setColor(Color.blue);
		g.fillRect(25, 75, 100, 20);
		g.drawString("Current RGB: " + g.getColor(), 130, 90);

		Color color = Color.MAGENTA;
		g.fillRect(25, 100, 100, 20);
		g.drawString("Current R: " + color.getRed() + " " + color.getGreen() + " " + color.getGreen() + " "
				+ color.getAlpha(), 130, 115);
	}

	public static void main(String args[]) {
		ShowColor application = new ShowColor();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
