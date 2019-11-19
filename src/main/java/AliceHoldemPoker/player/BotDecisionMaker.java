package AliceHoldemPoker.player;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

/**
 * Bot decision maker, for now always plays
 * 
 * @author Manuel Moranchel
 *
 */
public class BotDecisionMaker implements PlayerVisitor {

	/*
	 *  @inheritDoc
	 */
	public boolean play(Player player, GameState gameState) {
		return true;
	}
}
