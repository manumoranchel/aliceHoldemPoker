package AliceHoldemPoker;

import org.junit.Test;

import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

import static org.junit.Assert.*;

public class EngineTest extends Engine {

	@Test
	public void testInitPlayers() {
		Engine engine = new Engine();
		engine.setGameState(new GameState());
		engine.initPlayers();
		assertTrue(engine.getGameState().getPlayers().size() == 4);
	}

	@Test
	public void testPlayersDealt() {
		Engine engine = new Engine();
		engine.setup();
		engine.deal();
		for (Player player : engine.getGameState().getPlayers()) {
			assertTrue(player.getCards().size() == 2);
		}
	}
	
	@Test
	public void testCommunityCardsDealt() {
		Engine engine = new Engine();
		engine.run();
		assertTrue(engine.getGameState().getCommunityFlopCards().size() == 5);
	}
}
