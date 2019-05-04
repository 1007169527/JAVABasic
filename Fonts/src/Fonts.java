
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Fonts extends JFrame {
	public Fonts() {
		super("Using Fonts");
		setSize(700, 400);
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
		// P427
		g.setFont(new Font("Serif", Font.BOLD, 12));
		g.drawString("Serif BOLD 12", 20, 50);

		g.setFont(new Font("Monospaced", Font.ITALIC, 24));
		g.drawString("Monospaced ITALIC 24", 20, 70);

		g.setFont(new Font("SansSerif", Font.PLAIN, 14));
		g.drawString("SansSerif PLAIN 14", 20, 90);

		g.setColor(Color.RED);
		g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 18));
		g.drawString(g.getFont().getName() + " " + g.getFont().getSize() + " " + g.getFont().getStyle() + "("
				+ Font.BOLD + " + " + Font.ITALIC + ")", 20, 110);

		// P428
		FontMetrics metrics = g.getFontMetrics();
		g.drawString("Current font: " + g.getFont(), 20, 130);
		g.drawString("Ascent: " + metrics.getAscent(), 20, 150);
		g.drawString("Descent: " + metrics.getDescent(), 20, 170);
		g.drawString("Height: " + metrics.getHeight(), 20, 190);
		g.drawString("Leading: " + metrics.getLeading(), 20, 210);

		Font font = new Font("Serif", Font.ITALIC, 14);
		metrics = g.getFontMetrics(font);
		g.drawString("Current font: " + g.getFont(), 20, 230);
		g.drawString("Ascent: " + metrics.getAscent(), 20, 250);
		g.drawString("Descent: " + metrics.getDescent(), 20, 270);
		g.drawString("Height: " + metrics.getHeight(), 20, 290);
		g.drawString("Leading: " + metrics.getLeading(), 20, 310);

	}

	public static void main(String args[]) {
		Fonts application = new Fonts();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
