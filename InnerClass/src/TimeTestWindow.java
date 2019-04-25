
//P347 + P268
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TimeTestWindow extends JFrame {
	private Time time;
	private JLabel hourLabel, minuteLabel, secondLabel;
	private JTextField hourField, minuteField, secondField, displayField;
	private JButton tickButton;

	public TimeTestWindow() {
		time = new Time();
		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		hourLabel = new JLabel("Set hour");
		hourField = new JTextField(10);
		container.add(hourLabel);
		container.add(hourField);
		minuteLabel = new JLabel("Set minute");
		minuteField = new JTextField(10);
		container.add(minuteLabel);
		container.add(minuteField);
		secondLabel = new JLabel("Set second");
		secondField = new JTextField(10);
		container.add(secondLabel);
		container.add(secondField);
		displayField = new JTextField(30);
		displayField.setEditable(false);
		container.add(displayField);
		tickButton = new JButton("Add 1 to Second");
		container.add(tickButton);

		ActionEventHandler handler = new ActionEventHandler();

		hourField.addActionListener(handler);
		minuteField.addActionListener(handler);
		secondField.addActionListener(handler);
		displayField.addActionListener(handler);
		tickButton.addActionListener(handler);

	}

	public void displayTime() {
		displayField
				.setText("Hour: " + time.getHour() + " Minute: " + time.getMinute() + " Second: " + time.getSecond());
	}

	private class ActionEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == tickButton) {
				tick();
			} else if (event.getSource() == hourField) {
				time.setHour(Integer.parseInt(event.getActionCommand()));
				hourField.setText("");
			} else if (event.getSource() == minuteField) {
				time.setMinute(Integer.parseInt(event.getActionCommand()));
				minuteField.setText("");
			} else if (event.getSource() == secondField) {
				time.setSecond(Integer.parseInt(event.getActionCommand()));
				secondField.setText("");
			}
			displayTime();
		}

		public void tick() {
			time.setSecond((time.getSecond() + 1) % 60);
			if (time.getSecond() == 0) {
				time.setMinute((time.getMinute() + 1) % 60);
				if (time.getMinute() == 0) {
					time.setHour((time.getHour() + 1) % 24);
				}
			}
		}
	}

	public static void main(String args[]) {
		TimeTestWindow window = new TimeTestWindow();
		window.setSize(400, 200);
		window.setVisible(true);
	}
}
