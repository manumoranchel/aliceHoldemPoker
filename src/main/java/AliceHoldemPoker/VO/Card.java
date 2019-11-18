package AliceHoldemPoker.VO;

/**
 * POJO to represent a card
 * 
 * @author Manuel Moranchel
 *
 */
public class Card {
	public enum Suit {
		CLOVERS, DIAMONDS, HEARTS, PIKES
	}

	/** Suit of the cards */
	private Suit suit;

	/**
	 * Value of the card. Please note the values will be as follow:
	 * 2-10 Representing the numbers
	 * 11 Jack
	 * 12 Queen
	 * 13 King
	 * 14 Ace
	 * This will ease the assessment of the value of the card
	 */
	private int number;

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
