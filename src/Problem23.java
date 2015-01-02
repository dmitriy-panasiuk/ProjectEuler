import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum
exceeds n. As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written
as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123
 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
 even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less
 than this limit.
Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/
public class Problem23 {
    private static final int UPPER = 28123;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(sum(UPPER));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static int sum(int upper) {
        Set<Integer> abundantNums = new HashSet<Integer>();
        Set<Integer> nums = new HashSet<Integer>();
        int sum = 0;

        for (int i = 12; i <= upper; i++) {
            if (isAbundant(i)) {
                abundantNums.add(i);
                fill(abundantNums, nums, i);
            }
        }

        for (int i = 1; i <= upper; i++) {
            if (!nums.contains(i))
                sum += i;
        }

        return sum;
    }


    private static void fill(Set<Integer> abundantNums, Set<Integer> nums, int n) {
        int s = 0;
        for (Integer abundantNum : abundantNums) {
            s = n + abundantNum;
            if (s <= UPPER)
                nums.add(s);
        }
    }

    private static boolean isAbundant(int n) {
        return n < sumOfDivisors(n);
    }

    private static int sumOfDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }
}
