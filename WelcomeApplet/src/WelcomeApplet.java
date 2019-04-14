import java.awt.Graphics;
import javax.swing.JApplet;

public class WelcomeApplet extends JApplet {
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(15,10,210,10);
		g.drawString("Welcome to", 25,25);
		g.drawString("Java Programming!", 25,40);
		g.drawLine(15,50,210,50);
	}
}
