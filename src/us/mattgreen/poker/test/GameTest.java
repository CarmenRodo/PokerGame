package us.mattgreen.poker.test;

import org.junit.Before;
import org.junit.Test;
import us.mattgreen.poker.Card;
import us.mattgreen.poker.Game;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static us.mattgreen.poker.Face.*;
import static us.mattgreen.poker.Suit.*;

public class GameTest {
    private Game game;
    private ArrayList<Card> hand;

    @Before
    public void setUp() {
        hand = new ArrayList<>();
        // Example hand setup, can be modified for different tests
        hand.add(new Card(THREE, CLUBS, 3));
        hand.add(new Card(THREE, DIAMONDS, 3));
        hand.add(new Card(THREE, HEARTS, 3));
        hand.add(new Card(FIVE, SPADES, 5));
        hand.add(new Card(FIVE, DIAMONDS, 5));
        game = new Game(hand);
    }

    @Test
    public void testFullHouse() {
        assertTrue("Full house should have matched", game.isFullHouse());
    }

    @Test
    public void testFlush() {
        // Set up a different hand for testing Flush
        hand.clear();
        hand.add(new Card(TEN, HEARTS, 10));
        hand.add(new Card(JACK, HEARTS, 11));
        hand.add(new Card(QUEEN, HEARTS, 12));
        hand.add(new Card(KING, HEARTS, 13));
        hand.add(new Card(ACE, HEARTS, 14));
        game = new Game(hand);
        assertTrue("Flush should have matched", game.isFlush());
    }

    @Test
    public void testThreeOfAKind() {
        // Set up a different hand for testing Three-of-a-Kind
        hand.clear();
        hand.add(new Card(TWO, SPADES, 2));
        hand.add(new Card(TWO, HEARTS, 2));
        hand.add(new Card(TWO, DIAMONDS, 2));
        hand.add(new Card(FOUR, SPADES, 4));
        hand.add(new Card(FIVE, CLUBS, 5));
        game = new Game(hand);
        assertTrue("Three-of-a-Kind should have matched", game.isThreeOfAKind());
    }

    @Test
    public void testFourOfAKind() {
        // Set up a different hand for testing Four-of-a-Kind
        hand.clear();
        hand.add(new Card(SEVEN, HEARTS, 7));
        hand.add(new Card(SEVEN, DIAMONDS, 7));
        hand.add(new Card(SEVEN, CLUBS, 7));
        hand.add(new Card(SEVEN, SPADES, 7));
        hand.add(new Card(FIVE, HEARTS, 5));
        game = new Game(hand);
        assertTrue("Four-of-a-Kind should have matched", game.isFourOfAKind());
    }

    @Test
    public void testStraight() {
        // Set up a Straight hand for testing
        hand.clear();
        hand.add(new Card(SIX, HEARTS, 6));
        hand.add(new Card(SEVEN, DIAMONDS, 7));
        hand.add(new Card(EIGHT, CLUBS, 8));
        hand.add(new Card(NINE, SPADES, 9));
        hand.add(new Card(TEN, HEARTS, 10));
        game = new Game(hand);
        assertTrue("Straight should have matched", game.isStraight());
    }

    @Test
    public void testTwoPair() {
        // Set up a Two Pair hand for testing
        hand.clear();
        hand.add(new Card(FIVE, HEARTS, 5));
        hand.add(new Card(FIVE, DIAMONDS, 5));
        hand.add(new Card(SEVEN, CLUBS, 7));
        hand.add(new Card(SEVEN, SPADES, 7));
        hand.add(new Card(JACK, HEARTS, 11));
        game = new Game(hand);
        assertTrue("Two Pair should have matched", game.isTwoPair());
    }

    @Test
    public void testOnePair() {
        // Set up a One Pair hand for testing
        hand.clear();
        hand.add(new Card(NINE, HEARTS, 9));
        hand.add(new Card(NINE, DIAMONDS, 9));
        hand.add(new Card(FOUR, CLUBS, 4));
        hand.add(new Card(EIGHT, SPADES, 8));
        hand.add(new Card(JACK, HEARTS, 11));
        game = new Game(hand);
        assertTrue("One Pair should have matched", game.isOnePair());
    }

    @Test
    public void testHighCard() {
        // Set up a High Card hand for testing
        hand.clear();
        hand.add(new Card(ACE, SPADES, 14));
        hand.add(new Card(KING, HEARTS, 13));
        hand.add(new Card(EIGHT, DIAMONDS, 8));
        hand.add(new Card(QUEEN, CLUBS, 12));
        hand.add(new Card(JACK, SPADES, 11));
        game = new Game(hand);
        assertTrue("High Card should have matched", game.isHighCard());
    }
    @Test
    public void testStraightFlush() {
        // Set up a Straight Flush hand for testing
        hand.clear();
        hand.add(new Card(SIX, HEARTS, 6));
        hand.add(new Card(SEVEN, HEARTS, 7));
        hand.add(new Card(EIGHT, HEARTS, 8));
        hand.add(new Card(NINE, HEARTS, 9));
        hand.add(new Card(TEN, HEARTS, 10));
        game = new Game(hand);
        assertTrue("Straight Flush should have matched", game.isStraightFlush());
    }

//    @Test
//    public void testRoyalFlush() {
//        // Set up a Royal Flush hand for testing
//        hand.clear();
//        hand.add(new Card(TEN, SPADES, 10));
//        hand.add(new Card(JACK, SPADES, 11));
//        hand.add(new Card(QUEEN, SPADES, 12));
//        hand.add(new Card(KING, SPADES, 13));
//        hand.add(new Card(ACE, SPADES, 14));
//        game = new Game(hand);
//        assertTrue("Royal Flush should have matched", game.isRoyalFlush());
//    }


}
