
//P844

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Card {
	private String face;
	private String suit;

	public Card(String initialFace, String initialSuit) {
		// TODO Auto-generated constructor stub
		face = initialFace;
		suit = initialSuit;
	}

	public String getSuit() {
		return suit;
	}

	public String getFace() {
		return face;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer(face + " of " + suit);
		buffer.setLength(20);
		return buffer.toString();
	}

}

public class Cards {
	private static final String suits[] = { "Hearts", "Clubs", "Diamonds", "Spades" };
	private static final String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Jack", "Queen", "King" };

	private List list;

	public Cards() {
		Card deck[] = new Card[52];

		for (int count = 0; count < deck.length; count++)
			deck[count] = new Card(faces[count % 13], suits[count % 4]);

		list = Arrays.asList(deck);
		Collections.shuffle(list);
	}

	public void printCards() {
		int half = list.size() / 2 - 1;
		for (int i = 0, j = half + 1; i <= half; i++, j++)
			System.out.println(list.get(i).toString() + list.get(j).toString());
	}

	public static void main(String[] args) {
		new Cards().printCards();
	}
}
