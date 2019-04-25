
//P352 + P268
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TimeTestWindow extends JFrame {
	private Time time;
	private JLabel hourLabel, minuteLabel, secondLabel;
	private JTextField hourField, minuteField, secondField, displayField;

	public TimeTestWindow() {
		time = new Time();
		createGUI();
		registerEventHandlers();
	}

	private void createGUI() {
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
	}

	private void registerEventHandlers() {
		hourField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				time.setHour(Integer.parseInt(event.getActionCommand()));
				hourField.setText("");
				displayTime();
			}
		});
		minuteField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				time.setMinute(Integer.parseInt(event.getActionCommand()));
				minuteField.setText("");
				displayTime();
			}
		});
		secondField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				time.setSecond(Integer.parseInt(event.getActionCommand()));
				secondField.setText("");
				displayTime();
			}
		});
	}

	public void displayTime() {
		displayField
				.setText("Hour: " + time.getHour() + " Minute: " + time.getMinute() + " Second: " + time.getSecond());
	}

	public static void main(String args[]) {
		TimeTestWindow window = new TimeTestWindow();
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		window.setSize(400, 150);
		window.setVisible(true);
	}
}
