package AliceHoldemPoker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

public class EngineTest extends Engine {

	@Test
	public void testInitPlayers() {
		Engine engine = new EngineTest();
		engine.setGameState(new GameState());
		engine.initPlayers();
		assertTrue(engine.getGameState().getPlayers().size() == 4);
	}

	@Test
	public void testPlayersDealt() {
		Engine engine = new EngineTest();
		engine.setup();
		engine.deal();
		for (Player player : engine.getGameState().getPlayers()) {
			assertTrue(player.getCards().size() == 2);
		}
	}
	
	@Test
	public void testCommunityCardsDealt() {
		Engine engine = new EngineTest();
		engine.run();
		assertTrue(engine.getGameState().getCommunityFlopCards().size() == 5);
	}
	
	/**
	 * Overriding method to have all bot players
	 */
	protected void setHumanPlayer() {
		return;
	}
}
