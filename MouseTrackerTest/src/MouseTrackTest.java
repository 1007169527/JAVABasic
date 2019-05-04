
//P471
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseTrackTest extends JFrame implements MouseListener, MouseMotionListener {
	private JLabel statusBar;

	public MouseTrackTest() {
		// TODO Auto-generated constructor stub
		super("Test MouseTracker");
		statusBar = new JLabel();
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		addMouseListener(this);
		addMouseMotionListener(this);
		setSize(275, 100);
		setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Dragged at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Moved at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Clicked at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Mouse entered at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Mouse exited at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Pressed at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		statusBar.setText("Released at [" + arg0.getX() + "," + arg0.getY() + "]");
	}

	public static void main(String args[]) {
		MouseTrackTest mouseTrackTest = new MouseTrackTest();
		mouseTrackTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
