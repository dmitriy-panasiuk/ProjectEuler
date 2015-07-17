import java.util.ArrayList;
import java.util.List;

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10
are given:
1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit
recurring cycle.
Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
*/
public class Problem26 {
    private static final int N = 1000;
    public static void main(String[] args) {
        System.out.println(longestCycle(1000));
        System.out.println(recurringCycle(983));
    }

    private static int longestCycle(int n) {
        int max = 0;
        int num = 0;
        int currentCycle = 0;

        for (int i = 2; i < n; i++) {
            currentCycle = recurringCycle(i);
            if (currentCycle > max) {
                max = currentCycle;
                num = i;
            }
        }

        return num;
    }

    private static int recurringCycle(int n) {
        List<Integer> remainders = new ArrayList<Integer>();
        int reminder = 10;

        while (reminder != 0) {
            reminder %= n;
            if (remainders.contains(reminder)) {
                return remainders.size() - remainders.indexOf(reminder);
            }
            remainders.add(reminder);
            reminder *= 10;
        }
        return 0;
    }
}
