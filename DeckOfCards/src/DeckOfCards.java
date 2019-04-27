
//P396
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeckOfCards extends JFrame {
	private Card deck[];
	private int currentCard;
	private JButton dealButton, shuffleButton;
	private JTextField displayField;
	private JLabel statusLabel;

	public DeckOfCards() {
		super("Card dealing Program");
		String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
				"Queen", "King" };
		String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

		deck = new Card[52];
		currentCard = -1;

		for (int count = 0; count < deck.length; count++) {
			deck[count] = new Card(faces[count % 12], suits[count / 13]);
		}

		Container container = getContentPane();
		container.setLayout(new FlowLayout());

		dealButton = new JButton("Deal card");
		dealButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Card dealt = dealCard();
				if (dealt != null) {
					displayField.setText(dealt.toString());
					statusLabel.setText("Card #: " + currentCard);
				} else {
					displayField.setText("No More Cards TO DEAL");
					statusLabel.setText("Shuffle cards to continue");
				}
			}
		});
		container.add(dealButton);

		shuffleButton = new JButton("Shuffle cards");
		shuffleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				displayField.setText("SHUFFLING ...");
				shuffle();
				displayField.setText("DECK IS SHUFFLED");
			}
		});
		container.add(shuffleButton);

		displayField = new JTextField(20);
		displayField.setEditable(false);
		container.add(displayField);

		statusLabel = new JLabel();
		container.add(statusLabel);

		setSize(275, 120);
		setVisible(true);

	}

	private Card dealCard() {
		if (++currentCard < deck.length)
			return deck[currentCard];
		else {
			dealButton.setEnabled(false);
			return null;
		}
	}

	private void shuffle() {
		currentCard = -1;
		for (int first = 0; first < deck.length; first++) {
			int second = (int) (Math.random() * 52);
			Card temp = deck[first];
			deck[first] = deck[second];
			deck[second] = temp;
		}
		dealButton.setEnabled(true);
	}

	public static void main(String args[]) {
		DeckOfCards application = new DeckOfCards();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Card {
	private String face;
	private String suit;

	public Card(String cardFace, String cardSuit) {
		face = cardFace;
		suit = cardSuit;
	}

	public String toString() {
		return face + " of " + suit;
	}

}