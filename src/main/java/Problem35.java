import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Helpers.Seed;

/*The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?*/
public class Problem35 {
    public static void main(String[] args) {
        Seed s = new Seed(1000000);
        //List<String> perms = new ArrayList<String>();
        List<Integer> rotations = new ArrayList<Integer>();
        List<Integer> primes = s.getPrimes_list();
        Set<Integer> circularPrimes = new HashSet<Integer>();
        for (Integer prime : primes) {
            boolean circular = true;
            rotations = getRotations(prime);
            for (Integer rotation : rotations) {
                if (!primes.contains(rotation)) {
                    circular = false;
                    break;
                }
            }
            if (circular) {
                for (Integer num : rotations) {
                    circularPrimes.add(num);
                }
            }
        }
        System.out.println(circularPrimes);
        System.out.println(circularPrimes.size());
    }

    private static void getPermutations(char[] chars, List<String> permutations, char[] current, int level) {
        if (level == current.length) {
            permutations.add(new String(current));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (level == 0 && i == 0)
                continue;
            current[level] = chars[i];
            getPermutations(chars, permutations, current, level + 1);
        }
    }

    private static void SEPAPermutations(char[] chars, List<String> permutations) {
        permutations.add(new String(chars));
        while (true) {
            int len = chars.length;
            int key = len - 1;
            int newKey = len - 1;

            while (key > 0 && chars[key] <= chars[key - 1]) {
                key--;
            }

            key--;

            if (key < 0) {
                return;
            }

            while (newKey > key && chars[newKey] <= chars[key]) {
                newKey--;
            }

            swap(chars, key, newKey);

            len--;
            key++;

            while (len > key) {
                swap(chars, len, key);
                key++;
                len--;
            }
            permutations.add(new String(chars));
        }
    }

    private static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    private static void getPermutations(char[] chars, List<String> permutations, boolean[] used, char[] current, int level) {
        if (level == chars.length) {
            permutations.add(new String(current));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i])
                continue;
            current[level] = chars[i];
            used[i] = true;
            getPermutations(chars, permutations, used, current, level + 1);
            used[i] = false;
        }
    }

    private static List<Integer> getRotations(int n) {
        List<Integer> rotations = new ArrayList<Integer>();
        int digitCount = ("" + n).length();
        int temp = 1;
        rotations.add(n);
        for (int i = 1; i < digitCount; i++) {
            temp *= 10;
        }
        for (int i = 1; i < digitCount; i++) {
            n = (n % temp) * 10 + (n / temp);
            rotations.add(n);
        }

        return rotations;
    }
}
