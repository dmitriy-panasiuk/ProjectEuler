import java.util.ArrayList;
import java.util.List;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits
1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
The lexicographic permutations of 0, 1 and 2 are:
012   021   102   120   201   210
What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/
public class Problem24 {
    private static final char[] chars = "0123".toCharArray();
    private static final int N = 1000000;

    public static void main(String[] args) {
        List<String> permutations = new ArrayList<String>();
        //getPermutations(chars, permutations, new boolean[chars.length], new char[chars.length], 0, N);
        permutations.add(new String(chars));
        Permutations.SEPAPermutations(chars, permutations);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    private static void getPermutations(char[] chars, List<String> permutations, boolean[] used, char[] current, int level, int n) {
        if (level == chars.length) {
            permutations.add(new String(current));
            if (permutations.size() == n) {
                System.out.println(new String(current));
                System.exit(1);
            }
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i])
                continue;
            current[level] = chars[i];
            used[i] = true;
            getPermutations(chars, permutations, used, current, level + 1, n);
            used[i] = false;
        }
    }


}

class Permutations {
    public static void SEPAPermutations(char[] chars, List<String> permutations) {
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
}

