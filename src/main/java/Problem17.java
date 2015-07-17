import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
letters used in total. If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many
letters would be used?
NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
(one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British
usage.
*/

public class Problem17 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(1, "one".length());
        m.put(2, "two".length());
        m.put(3, "three".length());
        m.put(4, "four".length());
        m.put(5, "five".length());
        m.put(6, "six".length());
        m.put(7, "seven".length());
        m.put(8, "eight".length());
        m.put(9, "nine".length());
        m.put(10, "ten".length());
        m.put(11, "eleven".length());
        m.put(12, "twelve".length());
        m.put(13, "thirteen".length());
        m.put(14, "fourteen".length());
        m.put(15, "fifteen".length());
        m.put(16, "sixteen".length());
        m.put(17, "seventeen".length());
        m.put(18, "eighteen".length());
        m.put(19, "nineteen".length());
        m.put(20, "twenty".length());
        m.put(30, "thirty".length());
        m.put(40, "forty".length());
        m.put(50, "fifty".length());
        m.put(60, "sixty".length());
        m.put(70, "seventy".length());
        m.put(80, "eighty".length());
        m.put(90, "ninety".length());
        int res = 0;
        for (int i = 1; i <= 999; i++) {
            res += parse(i, m);
        }
        System.out.println(res + "one thousand".length());
    }

    static int parse(int n, Map<Integer, Integer> map) {
        int result = 0;
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) return 0;
        if (n >= 100) {
            result = parse(n / 100, map) + "hundred".length();
            if (n % 100 > 0) {
                result += "and".length() + parse(n % 100, map);
            }
        } else {
            result = parse((n / 10) * 10, map) + parse(n % 10, map);
        }

        return result;
    }
}

