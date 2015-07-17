import java.util.ArrayList;
import java.util.List;

/*145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
Find the sum of all numbers which are equal to the sum of the factorial of their digits.
Note: as 1! = 1 and 2! = 2 are not sums they are not included.*/
public class Problem34 {
    private static final char[] chars_n2 = "01234".toCharArray();
    private static final char[] chars_n3 = "012345".toCharArray();
    private static final char[] chars_n4 = "01234567".toCharArray();
    private static final char[] chars_n5 = "012345678".toCharArray();
    private static final char[] chars_n6 = "0123456789".toCharArray();
    private static final char[] chars_n7 = "0123456789".toCharArray();
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public static void main(String[] args) {
        int sum = 0;
        List<String> permutations09 = new ArrayList<String>();
        getPermutations(chars_n2, permutations09, new char[2], 0);
        getPermutations(chars_n3, permutations09, new char[3], 0);
        getPermutations(chars_n4, permutations09, new char[4], 0);
        getPermutations(chars_n5, permutations09, new char[5], 0);
        getPermutations(chars_n6, permutations09, new char[6], 0);
        getPermutations(chars_n7, permutations09, new char[7], 0);
        for (String num : permutations09) {
            if (check(num)) {
                sum += Integer.parseInt(num);
            }
        }
        System.out.println(sum);
    }

    private static boolean check(String str) {
        int powersSum = 0;
        int currentDigit = 0;
        for (int i = 0; i < str.length(); i++) {
            currentDigit = Integer.parseInt(str.substring(i, i + 1));
            powersSum += factorials[currentDigit];
        }

        return Integer.parseInt(str) == powersSum;
    }

    private static void getPermutations(char[] chars, List<String> permutations, char[] current, int level) {
        if (level == current.length) {
            permutations.add(new String(current));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (level == 0 && i == 0)
                continue;
            current[level] = chars[i];
            getPermutations(chars, permutations, current, level + 1);
        }
    }
}
