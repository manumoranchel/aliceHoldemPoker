package AliceHoldemPoker.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

/**
 * Human decision maker based on input from console
 * 
 * @author Manuel Moranchel
 *
 */
public class HumanDecisionMaker implements PlayerVisitor {

	Logger logger = Logger.getLogger(HumanDecisionMaker.class.getName());

	/*
	 * @inheritDoc
	 */
	public boolean play(Player player, GameState gameState) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Game State: " + gameState.toString());
			System.out.println("You are playing:" + player.toString());
			System.out.println("(1) Fold (2)Call");
			int i = Integer.parseInt(br.readLine());
			return i == 2;
		} catch (NumberFormatException nfe) {
			logger.log(Level.SEVERE, nfe.getMessage());
		} catch (IOException ioe) {
			logger.log(Level.SEVERE, ioe.getMessage());
		}
		// if something goes wrong invalidate the player
		return false;
	}
}
