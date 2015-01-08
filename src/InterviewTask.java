import Helpers.Combinator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*We have numbers 1, 3, 4 and 6. Create an expression using any elementary operators (+, -, *, /),
containing only these numbers, exactly once each, such that the result is 24.*/
public class InterviewTask {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println(Combinator.getPermutations(numbers));
    }
}
