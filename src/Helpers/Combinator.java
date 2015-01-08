package Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combinator {
    public static <E> List<List<E>> getPermutations(List<E> initial) {
        List<List<E>> permutations = new ArrayList<List<E>>();
        getPermutations(initial, permutations, new boolean[initial.size()], new ArrayList<E>(initial), 0);
        return permutations;
    }

    private static <E> void getPermutations(List<E> chars, List<List<E>> permutations, boolean[] used, List<E> current, int level) {
        if (level == chars.size()) {
            permutations.add(new ArrayList<E>(current));
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            if (used[i])
                continue;
            current.set(level, chars.get(i));
            used[i] = true;
            getPermutations(chars, permutations, used, current, level + 1);
            used[i] = false;
        }
    }
}
