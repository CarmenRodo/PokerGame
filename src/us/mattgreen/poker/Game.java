package us.mattgreen.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private ArrayList<Card> hand;

    public Game(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public boolean isFullHouse() {
        Map<Face, Integer> faceCounts = new HashMap<>();
        for (Card card : hand) {
            faceCounts.put(card.getFace(), faceCounts.getOrDefault(card.getFace(), 0) + 1);
        }
        return faceCounts.containsValue(3) && faceCounts.containsValue(2);
    }

    public boolean isFlush() {
        Suit firstSuit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (card.getSuit() != firstSuit) return false;
        }
        return true;
    }

    public boolean isThreeOfAKind() {
        Map<Face, Integer> faceCounts = new HashMap<>();
        for (Card card : hand) {
            faceCounts.put(card.getFace(), faceCounts.getOrDefault(card.getFace(), 0) + 1);
        }
        return faceCounts.containsValue(3) && !faceCounts.containsValue(2);
    }

    public boolean isFourOfAKind() {
        Map<Face, Integer> faceCounts = new HashMap<>();
        for (Card card : hand) {
            faceCounts.put(card.getFace(), faceCounts.getOrDefault(card.getFace(), 0) + 1);
        }
        return faceCounts.containsValue(4);
    }
    public boolean isStraight() {
        // Check for a Straight: five consecutive cards of different suits.
        ArrayList<Face> faces = new ArrayList<>();
        for (Card card : hand) {
            faces.add(card.getFace());
        }
        Collections.sort(faces);

        for (int i = 1; i < faces.size(); i++) {
            if (faces.get(i).ordinal() - faces.get(i - 1).ordinal() != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isTwoPair() {
        // Check for Two Pair: two sets of pairs.
        Map<Face, Integer> faceCounts = new HashMap<>();
        for (Card card : hand) {
            faceCounts.put(card.getFace(), faceCounts.getOrDefault(card.getFace(), 0) + 1);
        }
        int pairCount = 0;
        for (Integer count : faceCounts.values()) {
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    public boolean isOnePair() {
        // Check for One Pair: two cards of the same rank.
        Map<Face, Integer> faceCounts = new HashMap<>();
        for (Card card : hand) {
            faceCounts.put(card.getFace(), faceCounts.getOrDefault(card.getFace(), 0) + 1);
        }
        return faceCounts.containsValue(2);
    }

    public boolean isHighCard() {
        // Check for High Card: when no other poker hand is made, and you have the highest card.
        Face highestFace = hand.get(0).getFace();
        for (Card card : hand) {
            if (card.getFace().ordinal() > highestFace.ordinal()) {
                highestFace = card.getFace();
            }
        }
        return true;
    }
    public boolean isRoyalFlush() {
        // Check for a Royal Flush: A, K, Q, J, 10, all of the same suit.
        Suit firstSuit = hand.get(0).getSuit();
        for (Card card : hand) {
            if (card.getSuit() != firstSuit || card.getFace() == Face.ACE || card.getFace() == Face.KING || card.getFace() == Face.QUEEN || card.getFace() == Face.JACK || card.getFace() == Face.TEN) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraightFlush() {
        // Check for a Straight Flush: five consecutive cards of the same suit.
        return isFlush() && isStraight();
    }
}
