
//P424
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser extends JFrame {
	private JButton changeColorButton;
	private Color color = Color.LIGHT_GRAY;
	private Container container;

	public ColorChooser() {
		super("ColorChooser");
		container = getContentPane();
		container.setLayout(new FlowLayout());

		changeColorButton = new JButton("Change Color");
		changeColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				color = JColorChooser.showDialog(ColorChooser.this, "Choose a color", color);
				if (color == null) {
					color = Color.LIGHT_GRAY;
				}
				container.setBackground(color);
			}
		});

		container.add(changeColorButton);
		setSize(400, 130);
		setVisible(true);
	}

	public static void main(String args[]) {
		ColorChooser application = new ColorChooser();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
