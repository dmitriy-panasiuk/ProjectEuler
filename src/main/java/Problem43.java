import Helpers.Combinator;

import java.util.Arrays;
import java.util.List;

/*The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some
order, but it also has a rather interesting sub-string divisibility property.

        Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

        d2d3d4=406 is divisible by 2
        d3d4d5=063 is divisible by 3
        d4d5d6=635 is divisible by 5
        d5d6d7=357 is divisible by 7
        d6d7d8=572 is divisible by 11
        d7d8d9=728 is divisible by 13
        d8d9d10=289 is divisible by 17
        Find the sum of all 0 to 9 pandigital numbers with this property.
*/
public class Problem43 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Character> chars = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        int d2d3d4, d3d4d5, d4d5d6, d5d6d7, d6d7d8, d7d8d9, d8d9d10;
        long sum = 0;
        for (List<Character> currentList : Combinator.getPermutations(chars)) {
            if (currentList.get(0) == '0') {
                continue;
            }
            d2d3d4 = Integer.parseInt("" + currentList.get(1) + currentList.get(2) + currentList.get(3));
            if (d2d3d4 % 2 != 0) {
                continue;
            }
            d3d4d5 = Integer.parseInt("" + currentList.get(2) + currentList.get(3) + currentList.get(4));
            if (d3d4d5 % 3 != 0) {
                continue;
            }
            d4d5d6 = Integer.parseInt("" + currentList.get(3) + currentList.get(4) + currentList.get(5));
            if (d4d5d6 % 5 != 0) {
                continue;
            }
            d5d6d7 = Integer.parseInt("" + currentList.get(4) + currentList.get(5) + currentList.get(6));
            if (d5d6d7 % 7 != 0) {
                continue;
            }
            d6d7d8 = Integer.parseInt("" + currentList.get(5) + currentList.get(6) + currentList.get(7));
            if (d6d7d8 % 11 != 0) {
                continue;
            }
            d7d8d9 = Integer.parseInt("" + currentList.get(6) + currentList.get(7) + currentList.get(8));
            if (d7d8d9 % 13 != 0) {
                continue;
            }
            d8d9d10 = Integer.parseInt("" + currentList.get(7) + currentList.get(8) + currentList.get(9));
            if (d8d9d10 % 17 != 0) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for (Character c : currentList) {
                sb.append(c);
            }
            System.out.println(sb.toString());
            sum += Long.parseLong(sb.toString());
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(sum);
    }
}
