package AliceHoldemPoker;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

public class Engine {
	
	Logger logger = Logger.getLogger(Engine.class.getName());

	/** POJO Representing the state of the game */
	private GameState gameState;

	public void run() {
		setup();

		// main game loop
		for (int round = 0; round < 5; round++) {
			logger.log(Level.INFO, "Running round:" + round);
			deal();
			getGameState().getCommunityFlopCards().add(getGameState().popCard());
		}
		rankWinner();
	}

	/**
	 * Once finish, determine the winner
	 */
	private List<Player> rankWinner() {
		return new ArrayList<Player>();
		
	}

	/**
	 * Deals cards to the players
	 */
	protected void deal() {
		//TODO MM for now, we always deal 2 cards to each player
		for (Player player : getGameState().getPlayers()) {
			logger.log(Level.INFO, "dealing for player [{0}]", player.toString());
			
			if (player.isPlaying() && player.play()) {
				player.getCards().clear();
				player.getCards().add(getGameState().popCard());
				player.getCards().add(getGameState().popCard());
			}
			
			logger.log(Level.INFO, "After dealing, player state: [{0}]", player.toString());
		}
	}

	/**
	 * Creates the initial state for the game
	 * 
	 */
	public void setup() {
		logger.log(Level.INFO, "Setting up the game");
		setGameState(new GameState());
		logger.log(Level.INFO, "Game play set");
		initPlayers();
		logger.log(Level.INFO, "Players initialised");
	}


	/**
	 * Register the players for the game
	 */
	protected void initPlayers() {
		getGameState().setPlayers(new ArrayList<Player>());
		for (int player = 0; player < 4; player++) {
			getGameState().getPlayers().add(new Player(String.valueOf(player)));
		}

	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
}
