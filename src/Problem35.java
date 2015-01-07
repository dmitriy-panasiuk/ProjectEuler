import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?*/
public class Problem35 {
    public static void main(String[] args) {
        Seed s = new Seed();
        List<String> perms = new ArrayList<String>();
        s.fill(1000000);
        Set<Integer> primes = s.getPrimes();
        Set<Integer> circularPrimes = new HashSet<Integer>();
        //SEPAPermutations("769".toCharArray(), perms);
        //getPermutations("769".toCharArray(), perms, new boolean[3], new char[3], 0);
        for (Integer prime : primes) {
            boolean allPrimes = true;
            perms.clear();
            //SEPAPermutations(("" + prime).toCharArray(), perms);
            getPermutations(("" + prime).toCharArray(), perms, new boolean[("" + prime).length()], new char[("" + prime).length()], 0);
            for (String str : perms) {
                if (!primes.contains(Integer.parseInt(str))) {
                    allPrimes = false;
                    break;
                }
            }
            if (allPrimes) {
                //System.out.println(perms);
                for (String str : perms) {
                    circularPrimes.add(Integer.parseInt(str));
                }
            }
        }
        System.out.println(circularPrimes);
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
}
