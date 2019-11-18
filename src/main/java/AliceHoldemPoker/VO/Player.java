package AliceHoldemPoker.VO;

import java.util.List;

/**
 * Representation of the Player and the cards playing
 * 
 * @author Manuel Moranchel
 *
 */
public class Player {

	/** The name of the player */
	private String name;

	/** The hand of the player. Always holds 2 cards */
	private List<Card> cards;

	/** Is the player still playing? */
	private Boolean playing;
	

//	TODO MM to implement in further iterations
//	private  int totalMoney;
//	private int currentBet;
//	private PlayerVisitor decisionManager;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Boolean getPlaying() {
		return playing;
	}

	public void setPlaying(Boolean playing) {
		this.playing = playing;
	}


}
