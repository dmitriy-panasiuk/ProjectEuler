/**
 The first two consecutive numbers to have two distinct prime factors are:

 14 = 2 × 7
 15 = 3 × 5

 The first three consecutive numbers to have three distinct prime factors are:

 644 = 2² × 7 × 23
 645 = 3 × 5 × 43
 646 = 2 × 17 × 19.

 Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 */

import Helpers.Seed;

import java.util.List;

public class Problem47 {
    public static void main(String[] args) {
        Seed seed = new Seed(1000000);
        int n = 0, number = 4;
        while (n != 4) {
            if (numberOfFactors(number, seed.getPrimes_list()) >= 4) {
                n++;
            } else {
                n = 0;
            }
            number++;
        }
        System.out.println(number);

    }

    private static int numberOfFactors(int n, List<Integer> list) {
        int factors = 0;
        int number = n, primeNumber = 0;
        int prevPrime = 0;

        while (number > 1) {
            if (number % list.get(primeNumber) == 0) {
                if (list.get(primeNumber) != prevPrime) {
                    factors++;
                    prevPrime = list.get(primeNumber);
                }
                number /= list.get(primeNumber);
            } else {
                primeNumber++;
            }
        }

        return factors;
    }
}
