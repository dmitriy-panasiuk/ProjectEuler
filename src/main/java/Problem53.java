/**
 * There are exactly ten ways of selecting three from five, 12345:
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * In combinatorics, we use the notation, 5C3 = 10.
 * In general,
 * nCr = n! / r!(n−r)!
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */
public class Problem53 {
    private static final int LIMIT = 1000_000;
    private static final int N = 100;

    public static void main(String[] args) {
        long n = 2, k, res = 0, c;
        while (n <= N) {
            k = n - 1;
            while (k >= 1) {
                c = combination(n, k);
                if ( c > LIMIT) {
                    res += k - (n - k)+ 1 ;
                    break;
                }
                k--;
            }
            n++;
        }

        System.out.println(res);
    }

    private static long combination(long n, long r) {
        if (r < (n / 2)) {
            return combination(n, n - r);
        }
        long res = 1, rTemp = n - 1;

        while (r <= rTemp) {
            res = res * (rTemp + 1) / (n - rTemp);
            rTemp--;
        }

        return res;
    }
}
