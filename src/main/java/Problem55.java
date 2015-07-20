import java.util.ArrayList;
import java.util.List;

/*
If we take 47, reverse and add, 47 + 74 = 121, which is palindromic.
Not all numbers produce palindromes so quickly. For example,
349 + 943 = 1292,
1292 + 2921 = 4213
4213 + 3124 = 7337
That is, 349 took three iterations to arrive at a palindrome.
Although no one has proved it yet, it is thought that some numbers, like 196, never produce a palindrome.
A number that never forms a palindrome through the reverse and add process is called a Lychrel number.
Due to the theoretical nature of these numbers, and for the purpose of this problem, we shall assume that a number
is Lychrel until proven otherwise. In addition you are given that for every number below ten-thousand, it will
 either (i) become a palindrome in less than fifty iterations, or, (ii) no one, with all the computing power that
 exists, has managed so far to map it to a palindrome. In fact, 10677 is the first number to be shown to require
 over fifty iterations before producing a palindrome: 4668731596684224866951378664 (53 iterations, 28-digits).
Surprisingly, there are palindromic numbers that are themselves Lychrel numbers; the first example is 4994.
How many Lychrel numbers are there below ten-thousand?
NOTE: Wording was modified slightly on 24 April 2007 to emphasise the theoretical nature of Lychrel numbers.
*/
public class Problem55 {
    private static final int N = 10000;
    private static final int N_ITER = 50;


    public static void main(String[] args) {
        int nLychrel = 0;
        long sum;

        outer: for (long i = 1; i < N; i++) {
            long n = i;
            for (int iter = 1; iter < N_ITER; iter++) {
                sum = n + reverseNumber(n);
                if (isPalindrom(sum)) {
                    System.out.println(i + " is not Lychrel");
                    continue outer;
                }
                n = sum;
            }
            nLychrel++;
        }

        System.out.println(nLychrel);
    }

    private static long reverseNumber(long n) {
        long res = 0;
        long temp = n;

        while (temp >= 1) {
            res = res * 10 + (temp % 10);
            temp /= 10;
        }

        return res;
    }

    private static boolean isPalindrom(long n) {
        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            digits.add((int) (n % 10));
            n /= 10;
        }
        for (int i = 0, j = digits.size() - 1; i < j; i++, j--) {
            if (!digits.get(i).equals(digits.get(j))) {
                return false;
            }
        }

        return true;
    }
}
