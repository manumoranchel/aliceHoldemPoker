package AliceHoldemPoker.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import AliceHoldemPoker.VO.Card;
import AliceHoldemPoker.VO.GameState;
import AliceHoldemPoker.VO.Player;

/**
 * Class to decide who is the winner player. Rank is based on: See
 * <a href="https://www.pokerlistings.com/poker-hand-ranking">Pokerlistings -
 * poker-hand-ranking</a>
 * 
 * @author Manuel Moranchel
 *
 */
public class PokerRank {

	Logger logger = Logger.getLogger(PokerRank.class.getName());

	/**
	 * Returns the winner. The integer is the index in player's list.
	 * 
	 * 
	 * @param gameState the state once the game is completed.
	 * @return the position of the winner in the player's array
	 */
	public int rankPlayers(GameState gameState) {
		List<Integer> valuePlayerHand = new ArrayList<Integer>();
		Integer playerHand;
		for (Player player : gameState.getPlayers()) {
			playerHand = rankHand(player.getCards(), gameState.getCommunityFlopCards());
			logger.log(Level.INFO, "Player:[{0}] - Hand:[{1}]", new Object[] { player.getName(), playerHand });
			valuePlayerHand.add(playerHand);
		}
		Integer bestHand = Collections.min(valuePlayerHand);
		// TODO MM if it is highest card (bestHand == 11, check which player has it
		logger.log(Level.INFO, "Best Hand:[{0}]", bestHand);
		return valuePlayerHand.indexOf(bestHand);
	}

	/**
	 * Given a player's cards and the community cards, get the best hand. The rank
	 * is calculated Highest to Lowest:
	 * <ul>
	 * <li>1: Royal flush</li>
	 * <li>2: Straight flush</li>
	 * <li>3: Royal flush</li>
	 * <li>4: Four of a kind</li>
	 * <li>5: Full house</li>
	 * <li>6: Flush</li>
	 * <li>7: Straight</li>
	 * <li>8: Three of a kind</li>
	 * <li>9: two Pair</li>
	 * <li>10: one Pair</li>
	 * <li>11: High card</li>
	 * 
	 * <ul>
	 * 
	 * @param cards
	 * @param communityFlopCards
	 * @return
	 */
	protected Integer rankHand(List<Card> cards, List<Card> communityFlopCards) {
		List<Card> allCards = new ArrayList<Card>();
		allCards.addAll(cards);
		allCards.addAll(communityFlopCards);

		// TODO MM implement all the hands
		if (isFourOfAKind(allCards)) {
			return 4;
		} else if (isthreeOfAKind(allCards)) {
			return 8;
		} else if (isOnePair(allCards)) {
			return 10;

		} else
			return 11;
	}

	/**
	 * Four cards equal number
	 * @param allCards community cards and player cards
	 * @return true if there is 4 equal cards
	 */
	protected boolean isFourOfAKind(List<Card> allCards) {
		int counter = 0;
		for (Card i : allCards) {
			counter = 0;
			for (Card j : allCards) {
				if (!(i.equals(j)) && (i.getNumber() == j.getNumber())) {
					counter++;
				}
			}
			if (counter == 3) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Three equal cards
	 * @param allCards community cards and player cards
	 * @return true if there is 4 equal cards
	 */
	protected boolean isthreeOfAKind(List<Card> allCards) {
		int counter = 0;
		for (Card i : allCards) {
			counter = 0;
			for (Card j : allCards) {
				if (!(i.equals(j)) && (i.getNumber() == j.getNumber())) {
					counter++;
				}
			}
			if (counter == 2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * One Pair
	 * @param allCards community cards and player cards
	 * @return true if there is 4 equal cards
	 */
	protected boolean isOnePair(List<Card> allCards) {
		{
			int counter = 0;
			for (Card i : allCards) {
				counter = 0;
				for (Card j : allCards) {
					//We need to check the two cards being compared aren't the same but have same number
					if (!(i.equals(j)) && (i.getNumber() == j.getNumber())) {
						counter++;
					}
				}
				if (counter == 1) {
					return true;
				}
			}
			return false;
		}

	}

}