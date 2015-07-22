import java.util.ArrayList;
import java.util.List;

/**
 * A googol (10100) is a massive number: one followed by one-hundred zeros; 100100 is almost unimaginably large:
 * one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 */
public class Problem56 {
    private static final int N = 100;

    public static void main(String[] args) {
        List<Integer> digitsA;
        int max = 0, temp;

        for (int a = 2; a < N; a++) {
            digitsA = new ArrayList<>();
            digitsA.add(a % 10);
            if (a >= 10) digitsA.add(a / 10);
            for (int b = 2; b < N; b++) {
                digitsA = multiply(digitsA, a);
                temp = sumOfDigits(digitsA);
                if (temp > max) {
                    max = temp;
                }
            }
        }

        System.out.println(max);
    }

    private static List<Integer> multiply(List<Integer> a, int b) {
        List<Integer> res = new ArrayList<>();
        int temp;
        int carryOver = 0;

        for (Integer anA : a) {
            temp = carryOver + anA * b;
            res.add(temp % 10);
            carryOver = temp / 10;
        }

        if (carryOver != 0) res.add(carryOver % 10);
        if (carryOver >= 10) res.add(carryOver / 10);

        return res;
    }

    private static int sumOfDigits(List<Integer> n) {
        int sum = 0;

        for (int d : n) {
            sum += d;
        }

        return sum;
    }
}
