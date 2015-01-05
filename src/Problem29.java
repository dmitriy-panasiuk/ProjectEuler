import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
        22=4, 23=8, 24=16, 25=32
        32=9, 33=27, 34=81, 35=243
        42=16, 43=64, 44=256, 45=1024
        52=25, 53=125, 54=625, 55=3125
If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:
        4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?*/
public class Problem29 {
    private static List<Integer> primes = primes(100);

    public static void main(String[] args) {
        Set<List<Integer>> distinctPowers = new HashSet<List<Integer>>();
        List<Integer> currentDivisors;
        for (int a = 2; a <= 100; a++) {
            currentDivisors = getDivisors(a);
            for (int b = 2; b <= 100; b++) {
                distinctPowers.add(multiplyList(currentDivisors, b));
            }
        }

        System.out.println(distinctPowers.size());
    }

    private static List<Integer> primes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (nextPrime(i, primes)) {
                primes.add(i);
            }
        }

        return primes;
    }

    private static boolean nextPrime(int n, List<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<Integer>();
        int i = 0;
        int currentPrime = primes.get(i);
        while (currentPrime * currentPrime <= n) {
            if (n % currentPrime == 0) {
                divisors.add(currentPrime);
                i = 0;
                n /= currentPrime;
            } else {
                i++;
            }
            currentPrime = primes.get(i);
        }
        divisors.add(n);
        return divisors;
    }

    private static List<Integer> multiplyList(List<Integer> list, int n) {
        List<Integer> l = new ArrayList<Integer>();
        for (Integer integer : list) {
            for (int i = 0; i < n; i++) {
                l.add(integer);
            }
        }

        return l;
    }
}
