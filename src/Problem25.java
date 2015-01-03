import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*The Fibonacci sequence is defined by the recurrence relation:
    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
    Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144
    The 12th term, F12, is the first term to contain three digits.

    What is the first term in the Fibonacci sequence to contain 1000 digits?*/
public class Problem25 {
    public static void main(String[] args) {
        Number n1 = new Number(1);
        Number n2 = new Number(2);
        Number n3 = new Number(0);
        int counter = 3;
        BigInteger i1 = BigInteger.valueOf(1);
        BigInteger i2 = BigInteger.valueOf(2);
        BigInteger i3 = BigInteger.valueOf(0);

        while (n3.digitCount() < 1000) {
            n3 = new Number(n1, n2);
            i3 = i1.add(i2);
            n1 = n2;
            n2 = n3;
            i1 = i2;
            i2 = i3;
            counter++;
            //System.out.println(counter + " " + n3);
        }
        System.out.println(i3);
        System.out.println(n3);
        System.out.println(counter);
    }
}

class Number {
    private List<Integer> number = new ArrayList<Integer>();

    public Number(int n) {
        number.add(n);
    }

    private void normalize() {
        for (int i = 0; i < number.size() - 1; i++) {
            number.set(i + 1, number.get(i) / 10 + number.get(i + 1));
            number.set(i, number.get(i) % 10);
        }
        while (number.get(number.size() - 1) > 10) {
            number.add(number.get(number.size() - 1) / 10);
            number.set(number.size() - 2, number.get(number.size() - 2) % 10);
        }
    }

    public Number(Number n1, Number n2) {
        int limit = Math.min(n1.number.size(), n2.number.size());
        for (int i = 0; i < limit; i++) {
            number.add(n1.number.get(i) + n2.number.get(i));
        }
        for (int i = limit; i < n1.number.size(); i++) {
            number.add(n1.number.get(i));
        }
        for (int i = limit; i < n2.number.size(); i++) {
            number.add(n2.number.get(i));
        }
        normalize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = number.size() - 1; i >= 0; i--) {
            sb.append(number.get(i));
        }

        return sb.toString();
    }

    public int digitCount() {
        return number.size();
    }
}
