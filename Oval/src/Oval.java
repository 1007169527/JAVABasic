import javax.swing.JApplet;
import java.awt.Graphics;

public class Oval extends JApplet {
	public void paint(Graphics g) {
		super.paint(g);
		int counter = 1;
		do {
			g.drawOval(110 - counter*10, 110 - counter*10, counter*20, counter*20);
			counter++;
		} while(counter <= 10);
	}
}
