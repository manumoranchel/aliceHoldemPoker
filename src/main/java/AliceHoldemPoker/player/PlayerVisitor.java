package AliceHoldemPoker.player;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

/**
 * Visitor interface. Play action will be performed by the classes implementing
 * this interface
 * 
 * @author Manuel Moranchel
 *
 */
public interface PlayerVisitor {

	/**
	 * Having the information of the player and the current game state, make a
	 * decision to play.
	 * 
	 * @param player
	 * @param gameState
	 * @return
	 */
	public boolean play(Player player, GameState gameState);
}
