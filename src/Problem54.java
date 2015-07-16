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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem54 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\resources\\problem54.txt"));

        String str;
        while (scanner.hasNext()) {

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
}
