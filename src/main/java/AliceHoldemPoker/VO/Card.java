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

	public Card(int number, Suit suit) {
		super();
		this.number = number;
		this.suit = suit;
	}

	public Card() {
		super();
	}
	
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(number);
		builder.append("-");
		builder.append(suit);
		builder.append("]");
		return builder.toString();
	}

}
