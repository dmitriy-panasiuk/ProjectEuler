import java.util.List;

import Helpers.Seed;

/*The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left:
3797, 379, 37, and 3.
Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.*/
public class Problem37 {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<Integer> primes = new Seed(1000000).getPrimes_list();
        int n = 0, i = 0, sum = 0;

        for (int prime : primes) {
            if (prime > 10 && isLeftTruncatable(prime, primes) && isRightTruncatable(prime, primes)) {
                System.out.println(prime);
                sum += prime;
            }
        }
        System.out.println(sum);
    }

    private static boolean isRightTruncatable(int n, List<Integer> primes) {
        while (n > 0) {
            if (!primes.contains(n)) {
                return false;
            }
            n /= 10;
        }

        return true;
    }

    private static boolean isLeftTruncatable(int n, List<Integer> primes) {
        int modifier = 1;
        while (n / modifier > 0) {
            modifier *= 10;
            if (!primes.contains(n % modifier)) {
                return false;
            }
        }

        return true;
    }
}
