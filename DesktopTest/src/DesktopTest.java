
//P520
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DesktopTest extends JFrame {
	private JDesktopPane theDesktopPane;

	public DesktopTest() {
		// TODO Auto-generated constructor stub
		super("Testing DesktopPane");
		JMenuBar bar = new JMenuBar();
		JMenu addMenu = new JMenu("Add");
		JMenuItem newFrame = new JMenuItem("Internal Frame");
		addMenu.add(newFrame);
		bar.add(addMenu);
		setJMenuBar(bar);
		theDesktopPane = new JDesktopPane();
		getContentPane().add(theDesktopPane);

		newFrame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
				Container container = frame.getContentPane();
				MyPanel panel = new MyPanel();
				container.add(panel, BorderLayout.CENTER);
				frame.pack();
				theDesktopPane.add(frame);
				frame.setVisible(true);
			}
		});

		setSize(600, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		DesktopTest desktopTest = new DesktopTest();
		desktopTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MyPanel extends JPanel {
	private ImageIcon imageIcon;
	private String[] images = { "home.gif", "help.gif", "focus.gif", "clear.gif" };

	public MyPanel() {
		// TODO Auto-generated constructor stub
		int randomNumber = (int) (Math.random() * 4);
		imageIcon = new ImageIcon(images[randomNumber]);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		imageIcon.paintIcon(this, g, 0, 0);
	}

	public Dimension getPreferredSize() {
		return new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
	}
}