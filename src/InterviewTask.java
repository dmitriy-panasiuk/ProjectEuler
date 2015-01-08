/*We have numbers 1, 3, 4 and 6. Create an expression using any elementary operators (+, -, *, /),
containing only these numbers, exactly once each, such that the result is 24.*/
import Helpers.Combinator;
import java.util.Arrays;
import java.util.List;

public class InterviewTask {
    public static void main(String[] args) {
        List<Character> numbers = Arrays.asList('1', '2', '3');
        System.out.println(Combinator.getPermutations(numbers));
        System.out.println(Combinator.getCombinations(numbers, 1));
    }
}
