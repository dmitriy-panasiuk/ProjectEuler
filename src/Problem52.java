import java.util.Arrays;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different
 * order. Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem52 {
    private static final int N = 6;

    public static void main(String[] args) {
        int i = 10;
        outer: while (true) {
            for (int j = 2; j <= N; j++) {
                if (!isSameDigits(i, i * j)) {
                    break;
                } else if (j == N) {
                    System.out.println(i);
                    break outer;
                }
            }
            i++;
        }
    }

    private static boolean isSameDigits(int n1, int n2) {
        char[] c1, c2;

        Arrays.sort(c1 = ("" + n1).toCharArray());
        Arrays.sort(c2 = ("" + n2).toCharArray());

        return isArraySame(c1, c2);
    }

    private static boolean isArraySame(char[] c1, char[] c2) {
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i])
                return false;
        }

        return true;
    }
}
