package AliceHoldemPoker;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;
import AliceHoldemPoker.player.BotDecisionMaker;
import AliceHoldemPoker.player.HumanDecisionMaker;
import AliceHoldemPoker.poker.PokerRank;

/**
 * Game engine. Run method is the starting point.
 * 
 * @author Manuel Moranchel
 *
 */
public class Engine {

	public static int NUMBER_ROUNDS = 5;
	public static int NUMBER_PLAYERS = 4;

	Logger logger = Logger.getLogger(Engine.class.getName());

	/** POJO Representing the state of the game */
	private GameState gameState;
	
	/** Utility class to determine the winner */
	private PokerRank pokerRank;

	/**
	 * Main method performing the game
	 */
	public void run() {
		setup();

		// main game loop
		for (int round = 0; round < NUMBER_ROUNDS; round++) {
			logger.log(Level.INFO, "Running round:" + round);
			deal();
			getGameState().getCommunityFlopCards().add(getGameState().popCard());
		}
		Integer winner = getPokerRank().rankPlayers(getGameState());
		System.out.println(MessageFormat.format("Player[{0}] wins. gameState:[{1}]]", gameState.getPlayers().get(winner), getGameState()));
	}
	

	/**
	 * Creates the initial state for the game
	 * 
	 */
	public void setup() {
		logger.log(Level.INFO, "Setting up the game");
		setGameState(new GameState());
		logger.log(Level.INFO, "Game play set");
		logger.log(Level.INFO, "Setting up player");
		initPlayers();
		logger.log(Level.INFO, "Players initialised");
		logger.log(Level.INFO, "Setting PokerRank");
		setPokerRank(new PokerRank());
		logger.log(Level.INFO, "PokerRank set");
	}

	/**
	 * Deals cards to the players
	 */
	protected void deal() {
		// TODO MM for now, we always deal 2 cards to each player
		for (Player player : getGameState().getPlayers()) {
			logger.log(Level.INFO, "dealing for player [{0}]", player.toString());

			if (player.isPlaying() && player.play(getGameState())) {
				player.getCards().clear();
				player.getCards().add(getGameState().popCard());
				player.getCards().add(getGameState().popCard());
			}

			logger.log(Level.INFO, "After dealing, player state: [{0}]", player.toString());
		}
	}

	/**
	 * Register the players for the game
	 */
	protected void initPlayers() {
		getGameState().setPlayers(new ArrayList<Player>());
		for (int player = 0; player < NUMBER_PLAYERS; player++) {
			getGameState().getPlayers().add(new Player(String.valueOf(player), new BotDecisionMaker()));
		}
		setHumanPlayer();
	}

	/**
	 * Define which player is the human. This method can be override in test classes
	 * to have all bot players
	 */
	protected void setHumanPlayer() {
		getGameState().getPlayers().get(0).setDecisionManager(new HumanDecisionMaker());
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public PokerRank getPokerRank() {
		return pokerRank;
	}

	public void setPokerRank(PokerRank pokerRank) {
		this.pokerRank = pokerRank;
	}
}
