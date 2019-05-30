import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JApplet;

public class ImageMap extends JApplet {
	private ImageIcon mapImages[];
	private static final String captions[] = { "picture 1", "picture 2", "picture 3", "picture 4" };

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				showStatus("Pointer outside applet");
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				showStatus(translateLocation(e.getX(), e.getY()));
			}
		});

		mapImages = new ImageIcon[4];
		for (int count = 0; count < mapImages.length; count++)
			mapImages[count] = new ImageIcon(getClass().getResource("images/loop" + count + ".jpg"));
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		mapImages[0].paintIcon(this, g, 0, 0);
		mapImages[1].paintIcon(this, g, mapImages[0].getIconWidth(), 0);
		mapImages[2].paintIcon(this, g, 0, mapImages[0].getIconHeight());
		mapImages[3].paintIcon(this, g, mapImages[0].getIconWidth(), mapImages[0].getIconHeight());
	}

	public String translateLocation(int x, int y) {
		if (x >= mapImages[0].getIconWidth() * 2 || y >= mapImages[0].getIconHeight() * 2)
			return "";
		int index_x = x / mapImages[0].getIconWidth();
		int index_y = y / mapImages[0].getIconHeight();
		// System.out.println("index_x = " + index_x + " index_y " + index_y);
		int iconNumber = index_x + index_y * 2;
		return captions[iconNumber];
	}
}
