import java.util.HashSet;
import java.util.Set;

/*
Take the number 192 and multiply it by each of 1, 2, and 3:
        192 × 1 = 192
        192 × 2 = 384
        192 × 3 = 576
By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product
of 192 and (1,2,3). The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving
the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5). What is the largest 1 to 9 pandigital
 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
*/
public class Problem38 {
    public static void main(String[] args) {
        //System.out.println(isPandigital("192384576"));
        String product = "";
        for (int i = 1; i < 10; i++) {
            product = concatProduct(i, 5);
            if (isPandigital(product)) System.out.println(i + " * " + "1.." + 5 + " = " + product);
            product = concatProduct(i, 6);
            if (isPandigital(product)) System.out.println(i + " * " + "1.." + 6 + " = " + product);
        }
        for (int i = 10; i < 99; i++) {
            product = concatProduct(i, 4);
            if (isPandigital(product)) System.out.println(i + " * " + "1.." + 4 + " = " + product);
        }
        for (int i = 100; i < 999; i++) {
            product = concatProduct(i, 3);
            if (isPandigital(product)) System.out.println(i + " * " + "1.." + 3 + " = " + product);
        }
        for (int i = 1000; i < 9999; i++) {
            product = concatProduct(i, 2);
            if (isPandigital(product)) System.out.println(i + " * " + "1.." + 2 + " = " + product);
        }
    }

    private static String concatProduct(int number, int n) {
        String product = "";
        for (int i = 1; i <= n; i++) {
            product += i * number;
        }

        return product;
    }

    private static boolean isPandigital(String number) {
        if (number.length() != 9) return false;
        boolean[] digits = new boolean[10];
        int ch = 0;
        for (int i = 0; i < number.length(); i++) {
            ch = number.charAt(i) - 48;
            if (ch == 0) return false;
            if (digits[ch]) return false;
            digits[ch] = true;
        }

        return true;
    }
}
