package AliceHoldemPoker.VO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import AliceHoldemPoker.VO.Card.Suit;

/**
 * Representation of the game. Ideally a VO should not contain logic however for
 * privacy, the creation of the deck is coded here encapsulating it content.
 * 
 * @author Manuel Moranchel
 *
 */
public class GameState {

	/** Deck */
	private LinkedList<Card> deck;

	/** Players */
	private List<Player> players;

	/** Flop cards */
	private List<Card> communityFlopCards;

	public GameState(LinkedList<Card> deck, List<Player> players, List<Card> communityFlopCards) {
		super();
		this.deck = deck;
		this.players = players;
		this.communityFlopCards = communityFlopCards;
	}

	public GameState() {
		super();
		this.deck = new LinkedList<Card>();
		initDeck();
		this.players = new ArrayList<Player>();
		this.communityFlopCards = new ArrayList<Card>();
	}

	/**
	 * Initialise the deck
	 */
	private void initDeck() {
		setDeck(new LinkedList<Card>());

		// Code complexity violation. However accepting it for code readability and
		// since it is a simple example
		for (Suit suit : Suit.values()) {
			for (int cardValue = 2; cardValue < 15; cardValue++) {
				getDeck().add(new Card(cardValue, suit));
			}
		}
		Collections.shuffle(getDeck());
	}

	/**
	 * This method exposes the content of the deck. Such information should be
	 * hidden. Use <code>popCard()</code> method instead.
	 * 
	 * @return the deck
	 */
	protected LinkedList<Card> getDeck() {
		return deck;
	}

	/**
	 * Gets the first card in the deck and removes it from the collection.
	 * 
	 * @return The cards from the deck
	 */
	public Card popCard() {
		return getDeck().remove();
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setDeck(LinkedList<Card> deck) {
		this.deck = deck;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Card> getCommunityFlopCards() {
		return communityFlopCards;
	}

	public void setCommunityFlopCards(List<Card> communityFlopCards) {
		this.communityFlopCards = communityFlopCards;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameState [deck=");
		builder.append(deck);
		builder.append(", players=");
		for (Player player : players) {
			builder.append(player);
		}
		builder.append(", communityFlopCards=");
		for (Card card : communityFlopCards) {
			builder.append(card);
		}
		builder.append("]");
		return builder.toString();
	}

}
