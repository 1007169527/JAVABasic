
//P173
// Container FlowLayout
import java.awt.Container;
import java.awt.FlowLayout;
// ActionListener ActionEvent
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JLabel JTextField JButton JApplet
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Craps extends JApplet implements ActionListener {
	final int WON = 0, LOST = 1, CONTINUE = 2;
	boolean firstRoll = true;
	int sumOfDice = 0;
	int myPoint = 0;
	int gameStatus = CONTINUE;
	JLabel dieLabel, die2Label, sumLabel, pointLabel;
	JTextField dieField, die2Field, sumField, pointField;
	JButton rollButton;

	public void init() {
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		dieLabel = new JLabel("Die 1");
		container.add(dieLabel);
		dieField = new JTextField(10);
		dieField.setEditable(false);
		container.add(dieField);

		die2Label = new JLabel("Die 2");
		container.add(die2Label);
		die2Field = new JTextField(10);
		die2Field.setEditable(false);
		container.add(die2Field);

		sumLabel = new JLabel("Sum is");
		container.add(sumLabel);
		sumField = new JTextField(10);
		sumField.setEditable(false);
		container.add(sumField);

		pointLabel = new JLabel("Point is");
		container.add(pointLabel);
		pointField = new JTextField(10);
		pointField.setEditable(false);
		container.add(pointField);

		rollButton = new JButton("Roll Dice");
		rollButton.addActionListener(this);
		container.add(rollButton);
	}

	public void actionPerformed(ActionEvent actionEvent) {
		sumOfDice = rollDice();

		if (firstRoll) {
			switch (sumOfDice) {
			case 7:
			case 11:
				gameStatus = WON;
				pointField.setText("");
				break;
			case 2:
			case 3:
			case 12:
				gameStatus = LOST;
				pointField.setText("");
				break;
			default:
				gameStatus = CONTINUE;
				myPoint = sumOfDice;
				pointField.setText(Integer.toString(myPoint));
				firstRoll = false;
				break;
			}
		} else {
			if (sumOfDice == myPoint) {
				gameStatus = WON;
			} else {
				if (sumOfDice == 7)
					gameStatus = LOST;
			}
		}

		displayMessage();
	}

	public int rollDice() {
		int die1 = 1 + (int) (Math.random() * 6);
		int die2 = 1 + (int) (Math.random() * 6);
		int sum = die1 + die2;
		dieField.setText(Integer.toString(die1));
		die2Field.setText(Integer.toString(die2));
		sumField.setText(Integer.toString(sum));
		return sum;
	}

	public void displayMessage() {
		if (gameStatus == CONTINUE)
			showStatus("Roll again");
		else {
			if (gameStatus == WON)
				showStatus("Player wins");
			else
				showStatus("Player loses");
			firstRoll = true;
		}
	}
}
