package Helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Seed {
    //private List<Integer> primes_list = new ArrayList<Integer>();
    //private Set<Integer> primes_set = new HashSet<Integer>();
    //private int upper = 2;
    private boolean[] primes_list;
    private int max;
    public Seed(int n) {
        max = n;
        primes_list = new boolean[n];
        fill(n);
        //this.upper = n;
    }

    public List<Integer> getPrimes_list() {
        throw new UnsupportedOperationException();
    }

    public void fill(int n) {
        for (int i = 3; i <= Math.sqrt(max); i += 2) {
            for (int j = i; i * j <= max; j += 2) {
                primes_list[i*j] = true;
            }
        }
    }

    public boolean isPrime(int n) {
        return n % 2 != 0 && !primes_list[n];
    }
}
