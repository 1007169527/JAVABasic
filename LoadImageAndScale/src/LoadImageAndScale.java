
//P743
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class LoadImageAndScale extends JApplet {
	private Image logo1;
	private ImageIcon logo2;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		logo1 = getImage(getDocumentBase(), "logo.gif");
		logo2 = new ImageIcon("logo.gif");
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(logo1, 0, 0, this);
		g.drawImage(logo1, 0, 300, this);
		g.drawImage(logo1, 0, 600, getWidth(), getHeight() - 600, this);
		logo2.paintIcon(this, g, 300, 0);
	}
}
