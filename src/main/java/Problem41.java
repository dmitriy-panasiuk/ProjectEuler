import Helpers.Combinator;

import java.util.Arrays;
import java.util.List;

/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
*/
public class Problem41 {
    public static void main(String[] args) {
        List<Character> chars = Arrays.asList('1', '2', '3', '4', '5', '6', '7');
        int currentNumber;
        for (List<Character> l : Combinator.getPermutations(chars)) {
            currentNumber = getNumFromList(l);
            if (isPrime(currentNumber)) {
                System.out.println(currentNumber);
            }
        }
        System.out.println();
    }

    private static int getNumFromList(List<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return Integer.parseInt(builder.toString());
    }

    private static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i < n; i+= 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
