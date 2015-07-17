package Helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Seed {
    private List<Integer> primes_list = new ArrayList<Integer>();
    private Set<Integer> primes_set = new HashSet<Integer>();
    private int upper = 2;
    public Seed(int n) {
        fill(n);
        this.upper = n;
    }

    public List<Integer> getPrimes_list() {
        return new ArrayList<Integer>(primes_list);
    }

    public void fill(int n) {
        for (int i = upper; i <= n; i++) {
            if (nextPrime(i)) {
                primes_list.add(i);
            }
        }
        primes_set = new HashSet<Integer>(primes_list);
    }

    private boolean nextPrime(int n) {
        for (Integer prime : primes_list) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int n) {
        fill(n);
        return primes_set.contains(n);
    }
}
