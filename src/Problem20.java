/*n! means n × (n − 1) × ... × 3 × 2 × 1

        For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
        and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

        Find the sum of the digits in the number 100!*/

import java.math.BigInteger;
import java.util.LinkedList;

public class Problem20 {
    private static LinkedList<Integer> digits = new LinkedList<Integer>();

    static {
        digits.add(0);
        digits.add(0);
        digits.add(8);
        digits.add(8);
        digits.add(2);
        digits.add(6);
        digits.add(3);
    }

    private static int n = 11;
    private static int endN = 100;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        /*for (int i = n; i <= endN; i++) {
            multiply(i, digits);
        }
        System.out.println(digitSum(digits));*/
        int sum=0;
        BigInteger bi = new BigInteger("1");
        for(int i=2;i<100;i++)
            bi=bi.multiply(new BigInteger(""+i));
        String s = bi.toString(10);
        for (int i=0; i<s.length();i++)
            sum=sum+Integer.parseInt(""+s.charAt(i));
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void multiply(int n, LinkedList<Integer> digits) {
        for (int i = 0; i < digits.size(); i++) {
            digits.set(i, digits.get(i) * n);
        }
        normalize(digits);
    }

    private static void normalize(LinkedList<Integer> digits) {
        for (int i = 0; i < digits.size() - 1; i++) {
            digits.set(i + 1, digits.get(i) / 10 + digits.get(i + 1));
            digits.set(i, digits.get(i) % 10);
        }
        while (digits.getLast() > 10) {
            digits.add(digits.get(digits.size() - 1) / 10);
            digits.set(digits.size() - 2, digits.get(digits.size() - 2) % 10);
        }
    }

    private static int digitSum(LinkedList<Integer> digits) {
        int sum = 0;
        for (Integer digit : digits) {
            sum += digit;
        }

        return sum;
    }
}
