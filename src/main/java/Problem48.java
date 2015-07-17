/**
 The series, 11 + 22 + 33 + ... + 1010 = 10405071317.

 Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000.
 */
public class Problem48 {
    private static long tens = (long)Math.pow(10, 10);

    public static void main(String[] args) {
        long n = 1;
        long result = 0;
        while (n <= 1000) {
            result = add(result, pow(n, n));
            n++;
        }
        System.out.println(result);
    }

    private static long add(long x, long y) {
        return (x + y) % tens;
    }

    private static long mult(long x, long y) {
        return (x * y) % tens;
    }

    private static long pow(long x, long y) {
        long result = 1;

        while (y > 0) {
            result = mult(x, result);
            y--;
        }

        return result;
    }
}