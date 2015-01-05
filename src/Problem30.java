import java.util.ArrayList;
import java.util.List;

/*Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
        1634 = 14 + 64 + 34 + 44
        8208 = 84 + 24 + 04 + 84
        9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.
The sum of these numbers is 1634 + 8208 + 9474 = 19316.
Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.*/
public class Problem30 {
    private static final char[] chars03 = "0123".toCharArray();
    private static final char[] chars05 = "012345".toCharArray();
    private static final char[] chars09 = "0123456789".toCharArray();

    public static void main(String[] args) {
        int sum = 0;
        List<String> permutations09 = new ArrayList<String>();
        getPermutations(chars03, permutations09, new char[3], 0);
        getPermutations(chars05, permutations09, new char[4], 0);
        getPermutations(chars09, permutations09, new char[5], 0);
        getPermutations(chars09, permutations09, new char[6], 0);

        for (int i = 0; i < permutations09.size(); i++) {
            if (check(permutations09.get(i))) {
                System.out.println(permutations09.get(i));
                sum += Integer.parseInt(permutations09.get(i));
            }
        }
        System.out.println(sum);
    }

    private static boolean check(String str) {
        int powersSum = 0;
        int currentDigit = 0;
        for (int i = 0; i < str.length(); i++) {
            currentDigit = Integer.parseInt(str.substring(i, i + 1));
            powersSum += currentDigit * currentDigit * currentDigit * currentDigit * currentDigit;
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
