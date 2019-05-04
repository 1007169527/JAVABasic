
//P481
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {
	private JButton leftButton, rightButton, centerButton;
	private FlowLayout layout;
	private Container container;

	private class ActionListenerNative implements ActionListener {
		private int flowLayoutType;

		public ActionListenerNative(int FlowLayoutType) {
			flowLayoutType = FlowLayoutType;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			layout.setAlignment(flowLayoutType);
			layout.layoutContainer(container);
		}

	}

	public FlowLayoutDemo() {
		super("FlowlayoutDemo");
		layout = new FlowLayout();
		container = getContentPane();
		container.setLayout(layout);

		leftButton = new JButton("Left");
		container.add(leftButton);
		leftButton.addActionListener(new ActionListenerNative(FlowLayout.LEFT));
		centerButton = new JButton("Center");
		container.add(centerButton);
		centerButton.addActionListener(new ActionListenerNative(FlowLayout.CENTER));
		rightButton = new JButton("Right");
		container.add(rightButton);
		rightButton.addActionListener(new ActionListenerNative(FlowLayout.RIGHT));

		setSize(300, 75);
		setVisible(true);
	}

	public static void main(String args[]) {
		FlowLayoutDemo flowLayoutDemo = new FlowLayoutDemo();
		flowLayoutDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
