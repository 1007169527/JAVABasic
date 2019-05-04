import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyboardDemo extends JFrame implements KeyListener {
	private String line1 = "", line2 = "", line3 = "";
	private JTextArea textArea;

	public KeyboardDemo() {
		// TODO Auto-generated constructor stub
		super("Test Keyboard");
		textArea = new JTextArea(10, 15);
		textArea.setText("Press any key on keyboard");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		getContentPane().add(textArea);

		addKeyListener(this);

		setSize(350, 100);
		setVisible(true);
	}

	private void setLines2and3(KeyEvent arg0) {
		line2 = "This key is " + (arg0.isActionKey() ? "" : "not " + "any action key");
		String temp = arg0.getKeyModifiersText(arg0.getModifiers());
		line3 = "Modifier keys pressed: " + (temp.equals("") ? "none" : temp);
		textArea.setText(line1 + "\n" + line2 + "\n" + line3 + "\n");
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		line1 = "Key pressed: " + arg0.getKeyText(arg0.getKeyCode());
		setLines2and3(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		line1 = "Key released: " + arg0.getKeyText(arg0.getKeyCode());
		setLines2and3(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		line1 = "Key typed: " + arg0.getKeyChar();
		setLines2and3(arg0);
	}

	public static void main(String args[]) {
		KeyboardDemo keyboardDemo = new KeyboardDemo();
		keyboardDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
