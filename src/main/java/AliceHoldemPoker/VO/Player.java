package AliceHoldemPoker.VO;

import java.util.ArrayList;
import java.util.List;

import AliceHoldemPoker.player.BotDecisionMaker;
import AliceHoldemPoker.player.PlayerVisitor;

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

	/** Delegate the game play to Player Visitor */
	private PlayerVisitor decisionManager;

//	TODO MM to implement in further iterations
//	private  int totalMoney;
//	private int currentBet;

	public Player(String name, List<Card> cards, boolean playing, PlayerVisitor decisionManager) {
		super();
		this.name = name;
		this.cards = cards;
		this.playing = playing;
		this.decisionManager = decisionManager;
	}

	public Player() {
		super();
		this.name = "";
		this.cards = new ArrayList<Card>();
		this.playing = true;
		this.decisionManager = new BotDecisionMaker();
	}

	public Player(String name, PlayerVisitor decisionManager) {
		super();
		this.name = name;
		this.decisionManager = decisionManager;
		this.cards = new ArrayList<Card>();
		this.playing = true;
	}

	/**
	 * Wrapper method to expose the verdict of the DecisionManager
	 * 
	 * @return true if the players calls the
	 */
	public boolean play(GameState gameState) {
		setPlaying(getDecisionManager().play(this, gameState));
		return isPlaying();
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

	public PlayerVisitor getDecisionManager() {
		return decisionManager;
	}

	public void setDecisionManager(PlayerVisitor decisionManager) {
		this.decisionManager = decisionManager;
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
