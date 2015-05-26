/**
 The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i)
 each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.

 There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 but there is one other 4-digit increasing sequence.

 What 12-digit number do you form by concatenating the three terms in this sequence?
 */
import Helpers.Seed;
import Helpers.Combinator;

import java.util.ArrayList;
import java.util.List;

public class Problem49 {
    public static void main(String[] args) {
        Seed seed = new Seed(10000);
        int thirdPrime;
        List<Integer> digits;
        List<Integer> primes_found;
        List<Integer> digitsPerms;
        for (int prime : seed.getPrimes_list()) {
            if (prime > 1486) {
                primes_found = new ArrayList<>();
                digits = new ArrayList<>();
                digits.add(prime % 10); digits.add((prime % 100) / 10); digits.add(prime / 1000);
                digits.add((prime / 100) % 10);
                digitsPerms = transform(Combinator.getPermutations(digits));
                for (int newPrime : digitsPerms) {
                    if (newPrime != prime && seed.isPrime(newPrime) && newPrime > 999) {
                        thirdPrime = Math.max(newPrime, prime) + Math.abs(newPrime - prime);
                        if (thirdPrime < 10000 && seed.isPrime(thirdPrime) && digitsPerms.contains(thirdPrime)) {
                            primes_found.add(prime);
                            primes_found.add(newPrime);
                            primes_found.add(thirdPrime);
                        }
                    }
                }
                if (primes_found.size() >= 3) {
                    for (int i : primes_found) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    private static List<Integer> transform(List<List<Integer>> lst) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lst) {
            result.add(list.get(0) * 1000 + list.get(1) * 100 + list.get(2) * 10 + list.get(3));
        }

        return result;
    }
}
