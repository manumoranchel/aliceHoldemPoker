package AliceHoldemPoker.VO;

import java.util.ArrayList;
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
	private boolean playing;
	

//	TODO MM to implement in further iterations
//	private  int totalMoney;
//	private int currentBet;
//	private PlayerVisitor decisionManager;
	
	public Player(String name, List<Card> cards, boolean playing) {
		super();
		this.name = name;
		this.cards = cards;
		this.playing = playing;
	}
	
	public Player() {
		super();
		this.name = "";
		this.cards = new ArrayList<Card>();
		this.playing = true;
	}
	
	public Player(String name) {
		super();
		this.name = name;
		this.cards = new ArrayList<Card>();
		this.playing = true;
	}
	
	/**
	 * Wrapper method to expose the verdict of the DecisionManager
	 * @return true if the players calls the 
	 */
	public boolean play() {
		//Decide whether the players calls in the rounds.
		//TODO MM delegate to the decisionManager
		return true;
	}

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

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=");
		builder.append(name);
		builder.append(", cards=");
		for (Card card : cards) {
			builder.append(card);
		}
		builder.append(", playing=");
		builder.append(playing);
		builder.append("]");
		return builder.toString();
	}


}
