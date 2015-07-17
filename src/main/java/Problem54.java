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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem54 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(Problem54.class.getResourceAsStream("problem54.txt"));

        PokerHand hand1, hand2;
        String[] s1 = new String[5];
        String[] s2 = new String[5];

        while (scanner.hasNext()) {
            s1[0]= scanner.next();
            s1[1]= scanner.next();
            s1[2]= scanner.next();
            s1[3]= scanner.next();
            s1[4]= scanner.next();

            s2[0]= scanner.next();
            s2[1]= scanner.next();
            s2[2]= scanner.next();
            s2[3]= scanner.next();
            s2[4]= scanner.next();

            hand1 = new PokerHand(s1);
            hand2 = new PokerHand(s2);
        }
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

        Card (String value) {
            suite = value.charAt(1);
            switch (value.charAt(0)) {
                case 'T' : this.value = 10;
                    break;
                case 'J' : this.value = 11;
                    break;
                case 'Q' : this.value = 12;
                    break;
                case 'K' : this.value = 13;
                    break;
                case 'A' : this.value = 14;
                    break;
                default: this.value = Integer.parseInt("" + value.charAt(0));
            }
        }
    }

    class Rank {
        private int rank;
        private List<Integer> values = new ArrayList<>();
        private int[] cardValues = new int[5];
        private char[] cardSuites = new char[5];

        Rank() {
            for (int i = 0; i < hand.length;i++) {
                cardValues[i] = hand[i].value;
                cardSuites[i] = hand[i].suite;
            }
            Arrays.sort(cardValues);
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
                if ((prevValue - cardValues[i]) != 1 ) {
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
                return;
            }

            if (isFlush()) {
                rank = 6;
                return;
            }
            if (isStraight()) {
                rank = 5;
                return;
            }
        }
    }
}
