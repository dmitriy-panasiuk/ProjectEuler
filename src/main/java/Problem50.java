/**
 The prime 41, can be written as the sum of six consecutive primes:

 41 = 2 + 3 + 5 + 7 + 11 + 13
 This is the longest sum of consecutive primes that adds to a prime below one-hundred.

 The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

 Which prime, below one-million, can be written as the sum of the most consecutive primes?
  */
import Helpers.Seed;

import java.util.ArrayList;
import java.util.List;

public class Problem50 {
    private static final int TRESHOLD = 1000000;

    public static void main(String[] args) {
        int sum = 0, primeDiff, distance = 0, maxPrime = 0, startIndex = 0, endIndex = 0;
        Seed seed = new Seed(10000);
        List<Integer> primeSums = new ArrayList<>();
        List<Integer> primes = seed.getPrimes_list();
        primeSums.add(sum);
        for (int prime : primes) {
            sum += prime;
            primeSums.add(sum);
        }

        for (int i = 0; i < primeSums.size(); i++) {
            if (primeSums.get(i) > TRESHOLD) {
                break;
            }
            for (int j = primeSums.size() - 1; j > i + distance; j--) {
                primeDiff = primeSums.get(j) - primeSums.get(i);
                if (primeDiff < TRESHOLD && isPrime(primeDiff)) {
                    if (distance < j - i) {
                        distance = j - i;
                        startIndex = i; endIndex = j;
                        maxPrime = primeDiff;
                        break;
                    }
                }
            }
        }
        System.out.println(maxPrime + " " + distance);
        for (int i = startIndex; i < endIndex; i++) {
            System.out.print(primes.get(i) + " ");
        }
    }
    private static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i+= 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
