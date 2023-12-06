package us.mattgreen.poker.test;

import org.junit.Before;
import org.junit.Test;
import us.mattgreen.poker.Card;
import us.mattgreen.poker.Game;

import static org.junit.Assert.assertTrue;
import static us.mattgreen.poker.Face.*;
import static us.mattgreen.poker.Suit.*;

public class GameTest {
    private Card[] hand;

    @Before
    public void setUp() {
        hand = new Card[]{new Card(JACK,CLUBS, 11), new Card(FIVE,CLUBS, 5), new Card(JACK,SPADES, 11)};
    }

    @Test
    public void twoOfAKindTest() {
        assertTrue("Two of a kind should have matched",Game.twoOfAKind(hand));
    }
}
