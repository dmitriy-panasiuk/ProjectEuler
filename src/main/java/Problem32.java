import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
the 5-digit number, 15234, is 1 through 5 pandigital. The product 7254 is unusual, as the identity, 39 × 186 = 7254,
containing multiplicand, multiplier, and product is 1 through 9 pandigital.
Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.*/
public class Problem32 {
    public static void main(String[] args) {
        List<String> perms = new ArrayList<String>();
        int first = 0, second = 0, product = 0, sum = 0;
        Permutations.SEPAPermutations(new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'}, perms);
        Set<Integer> products = new HashSet<Integer>();

        for (int i = 0; i < perms.size(); i++) {
            first = Integer.parseInt(perms.get(i).substring(0, 1));
            second = Integer.parseInt(perms.get(i).substring(1, 5));
            product = Integer.parseInt(perms.get(i).substring(5));
            if (first * second == product) {
                products.add(product);
            }
            first = Integer.parseInt(perms.get(i).substring(0, 2));
            second = Integer.parseInt(perms.get(i).substring(2, 5));
            if (first * second == product) {
                products.add(product);
            }
        }
        for (Integer i : products) {
            sum += i;
        }
        System.out.println(sum);
    }
}
