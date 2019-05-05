
//P503
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class SelfContainedPanelTest extends JFrame {
	private SelfContainedPanel myPanel;

	public SelfContainedPanelTest() {
		// TODO Auto-generated constructor stub
		myPanel = new SelfContainedPanel();
		myPanel.setBackground(Color.YELLOW);

		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(myPanel);

		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				setTitle("Moving: " + "(" + e.getX() + ", " + e.getY() + ")");
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				setTitle("Dragging: " + "(" + e.getX() + ", " + e.getY() + ")");
			}
		});

		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		SelfContainedPanelTest selfContainedPanelTest = new SelfContainedPanelTest();
		selfContainedPanelTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
