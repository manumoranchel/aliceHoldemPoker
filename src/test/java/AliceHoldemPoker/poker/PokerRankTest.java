package AliceHoldemPoker.poker;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import AliceHoldemPoker.VO.Card;
import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;
import AliceHoldemPoker.VO.Card.Suit;

public class PokerRankTest extends PokerRank {

	@Test
	public void testRankPlayers() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		GameState gameState = new GameState();
		Player player = new Player();

		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		player.setCards(cards);
		gameState.getPlayers().add(player);

		player = new Player();

		cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(1, Suit.DIAMONDS));
		player.setCards(cards);
		gameState.getPlayers().add(player);

		cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.HEARTS));
		cards.add(new Card(11, Suit.PIKES));
		cards.add(new Card(12, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));
		
		gameState.setCommunityFlopCards(cards);

		assertTrue(pokerRankTest.rankPlayers(gameState) == 0);
	}

	@Test
	public void testIsOnePairPositiveScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		cards.add(new Card(12, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertTrue(pokerRankTest.isOnePair(cards));
	}

	@Test
	public void testIsOnePairNegativeScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(2, Suit.DIAMONDS));
		cards.add(new Card(12, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertFalse(pokerRankTest.isOnePair(cards));
	}

	@Test
	public void testIsthreeOfAKindPositiveScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		cards.add(new Card(11, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertTrue(pokerRankTest.isthreeOfAKind(cards));
	}

	@Test
	public void testIsthreeOfAKindNegativeScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		cards.add(new Card(12, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertFalse(pokerRankTest.isthreeOfAKind(cards));
	}

	@Test
	public void testIsFourOfAKindPositiveScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		cards.add(new Card(11, Suit.HEARTS));
		cards.add(new Card(11, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertTrue(pokerRankTest.isFourOfAKind(cards));
	}

	@Test
	public void testIsFourOfAKindNegativeScenario() {
		PokerRankTest pokerRankTest = new PokerRankTest();
		List<Card> cards = new ArrayList<Card>();
		cards.add(new Card(11, Suit.CLOVERS));
		cards.add(new Card(11, Suit.DIAMONDS));
		cards.add(new Card(11, Suit.HEARTS));
		cards.add(new Card(1, Suit.PIKES));
		cards.add(new Card(4, Suit.DIAMONDS));

		assertFalse(pokerRankTest.isFourOfAKind(cards));
	}

}