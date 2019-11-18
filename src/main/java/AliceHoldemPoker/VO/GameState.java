package AliceHoldemPoker.VO;

import java.util.List;

/**
 * Representation of the game
 * 
 * @author Manuel Moranchel
 *
 */
public class GameState {

	/** Deck */
	private List<Card> deck;

	/** Players */
	private List<Player> players;

	/** Flop cards */
	private List<Card> communityFlopCards;

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	public List<Player> getPlayers() {
		return players;
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

}
