import java.io.FileNotFoundException;
import java.util.Scanner;

/*
The nth term of the sequence of triangle numbers is given by, tn = ?n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we
form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle
number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common
 English words, how many are triangle words?
*/
public class Problem42 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(Problem42.class.getResourceAsStream("problem42.txt"));
        scanner.useDelimiter(",");
        String str;
        int value, numberOfTriangles = 0;
        while (scanner.hasNext()) {
            str = scanner.next().replaceAll("\"", "");
            value = wordValue(str);
            if (isTriangle(value)) {
                //System.out.println(str + " value is " + value);
                numberOfTriangles++;
            }
        }
        System.out.println(numberOfTriangles);
    }

    private static int wordValue(String word) {
        int value = 0;
        for (int i = 0; i < word.length(); i++) {
            value += word.charAt(i)- 64;
        }
        return value;
    }

    private static boolean isTriangle(int n) {
        return isPerfectSquare(8 * n + 1);
    }

    public static boolean isPerfectSquare(long n)
    {
        if (n < 0)
            return false;

        long tst = (long)(Math.sqrt(n) + 0.5);
        return tst*tst == n;
    }
}
