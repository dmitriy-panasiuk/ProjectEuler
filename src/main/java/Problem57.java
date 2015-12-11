import Helpers.BigNumber;

/**
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * By expanding this for the first four iterations, we get:
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example
 * where the number of digits in the numerator exceeds the number of digits in the denominator.
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */
public class Problem57 {
    private static final int N = 1000;

    public static void main(String[] args) {
        BigNumber numerator = new BigNumber(3), denominator = new BigNumber(2), temp;
        int res = 0;

        for (int i = 2; i <= N; i++) {
            temp = denominator;
            denominator = numerator.add(denominator);
            numerator = denominator.add(temp);
            if (numerator.digitCount() > denominator.digitCount()) {
                res++;
                System.out.println(i + " " + numerator + " " + denominator);
            }
        }

        System.out.println(res);
    }
}
