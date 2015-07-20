/*
In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards
(separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can
assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order,
and in each hand there is a clear winner.

How many hands does Player 1 win?
*/

import java.io.FileNotFoundException;
import java.util.*;

public class Problem54 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(Problem54.class.getResourceAsStream("problem54.txt"));
        int firstPlayerWins = 0;

        PokerHand hand1, hand2;
        String[] s1 = new String[5];
        String[] s2 = new String[5];

        while (scanner.hasNext()) {
            s1[0] = scanner.next();
            s1[1] = scanner.next();
            s1[2] = scanner.next();
            s1[3] = scanner.next();
            s1[4] = scanner.next();

            s2[0] = scanner.next();
            s2[1] = scanner.next();
            s2[2] = scanner.next();
            s2[3] = scanner.next();
            s2[4] = scanner.next();

            hand1 = new PokerHand(s1);
            hand2 = new PokerHand(s2);
            if (hand1.getRank().compareTo(hand2.getRank()) > 0) {
                firstPlayerWins++;
            }
            /*if (hand1.getRank().compareTo(hand2.getRank()) == 0) {
                System.out.println(Arrays.toString(s1));
                System.out.println(Arrays.toString(s2));
                System.out.println(hand1.getRank());
                System.out.println(hand2.getRank());
                System.out.println(hand1.getRank().compareTo(hand2.getRank()));

            }*/

        }
        System.out.println(firstPlayerWins);
    }
}

class PokerHand {
    private Card[] hand = new Card[5];

    PokerHand(String[] cards) {
        int i = 0;
        for (String card : cards) {
            hand[i] = new Card(card);
            i++;
        }
    }

    class Card {
        private int value;
        private char suite;

        Card(String value) {
            suite = value.charAt(1);
            switch (value.charAt(0)) {
                case 'T':
                    this.value = 10;
                    break;
                case 'J':
                    this.value = 11;
                    break;
                case 'Q':
                    this.value = 12;
                    break;
                case 'K':
                    this.value = 13;
                    break;
                case 'A':
                    this.value = 14;
                    break;
                default:
                    this.value = Integer.parseInt("" + value.charAt(0));
            }
        }
    }

    class Rank implements Comparable<Rank> {
        private int rank;
        private int[] cardValues = new int[5];
        private char[] cardSuites = new char[5];
        private Map<Integer, String> rankValues = new HashMap<>();
        private Map<Integer, Integer> rankAddValues = new HashMap<>();

        Rank() {
            for (int i = 0; i < hand.length; i++) {
                cardValues[i] = hand[i].value;
                cardSuites[i] = hand[i].suite;
            }
            Arrays.sort(cardValues);
            rankValues.put(1, "High Card");
            rankValues.put(2, "One Pair");
            rankValues.put(3, "Two Pairs");
            rankValues.put(4, "Three of a Kind");
            rankValues.put(5, "Straight");
            rankValues.put(6, "Flush");
            rankValues.put(7, "Full House");
            rankValues.put(8, "Four of a Kind");
            rankValues.put(9, "Straight Flush");
            init();
        }

        private boolean isFlush() {
            char c = cardSuites[0];
            for (char ch : cardSuites) {
                if (ch != c) {
                    return false;
                }
            }

            return true;
        }

        private boolean isStraight() {
            int prevValue = cardValues[0];
            for (int i = 1; i < cardValues.length; i++) {
                if ((cardValues[i] - prevValue) != 1) {
                    return false;
                }
                prevValue = cardValues[i];
            }

            return true;
        }

        private void init() {

            //Straight flush or Royalflush
            if (isFlush() && isStraight()) {
                rank = 9;
                rankAddValues.put(0, cardValues[4]);
                return;
            }
            //Flush
            if (isFlush()) {
                rank = 6;
                rankAddValues.put(0, cardValues[4]);
                return;
            }
            //Straight
            if (isStraight()) {
                rank = 5;
                rankAddValues.put(0, cardValues[4]);
                return;
            }
            //Any other
            List<Integer> series = new ArrayList<>();
            int range = 1;
            for (int i = 1; i < 5; i++) {
                if (cardValues[i] == cardValues[i - 1]) {
                    range++;
                } else if (range > 1) {
                    series.add(range);
                    rankAddValues.put(range, cardValues[i - 1]);
                    range = 1;
                }
            }
            if (range > 1) {
                series.add(range);
                rankAddValues.put(range, cardValues[4]);
            }
            Collections.sort(series);
            if (series.size() == 0) {
                rank = 1;
                return;
            }
            if (series.size() == 1) {
                switch (series.get(0)) {
                    case 2:
                        rank = 2;
                        break;
                    case 3:
                        rank = 4;
                        break;
                    case 4:
                        rank = 8;
                        break;
                }
                return;
            }
            if (series.size() == 2) {
                if (series.get(0).equals(series.get(1))) {
                    rank = 3;
                } else {
                    rank = 7;
                }
            }
        }

        @Override
        public String toString() {
            String res = "" + rankValues.get(rank) + " : ";
            for (Map.Entry e : rankAddValues.entrySet()) {
                res += e.getKey() + " - " + e.getValue() + " ";
            }
            return res;
        }


        @Override
        public int compareTo(Rank o) {
            if (rank > o.rank) {
                return 1;
            }
            if (rank < o.rank) {
                return -1;
            }
            if (rankAddValues.size() == 0) {
                for (int i = 4; i >= 0; i--) {
                    if (cardValues[i] > o.cardValues[i]) {
                        return 1;
                    }
                    if (cardValues[i] < o.cardValues[i]) {
                        return -1;
                    }
                }
                return 0;
            }
            if (rankAddValues.size() == 2) {
                throw new IllegalArgumentException("Two arguments in rank values");
            }
            if (rankAddValues.get(2) > o.rankAddValues.get(2)) {
                return 1;
            }
            if (rankAddValues.get(2) < o.rankAddValues.get(2)) {
                return -1;
            }
            for (int i = 4; i >= 0; i--) {
                if (cardValues[i] > o.cardValues[i]) {
                    return 1;
                }
                if (cardValues[i] < o.cardValues[i]) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public Rank getRank() {
        return new Rank();
    }


}
