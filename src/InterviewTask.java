/*We have numbers 1, 3, 4 and 6. Create an expression using any elementary operators (+, -, *, /),
containing only these numbers, exactly once each, such that the result is 24.*/
import Helpers.Combinator;
import java.util.Arrays;
import java.util.List;

public class InterviewTask {
    public static void main(String[] args) {
        List<Character> numbers = Arrays.asList('1', '2', '3');
        Rational r = new Rational(2);
        System.out.println(r.add(new Rational(3)));
        System.out.println(r.subtract(new Rational(3)));
        System.out.println(r.multiply(new Rational(3)));
        System.out.println(r.divide(new Rational(1)));

    }
}

class Rational {
    private int numerator;
    private int denominator;

    Rational(int numerator) {
        this(numerator, 1);
    }

    Rational(int numerator, int denominator) {
        if(denominator == 0) throw new IllegalArgumentException("denominator can't be zero!");
        this.numerator = numerator;
        this.denominator = denominator;
        normalize();
    }

    public Rational add(Rational that) {
        return new Rational(this.numerator * that.denominator + this.denominator*that.numerator,
                                        this.denominator * that.denominator);
    }

    public Rational subtract(Rational that) {
        return this.add(that.negate());
    }

    public Rational multiply(Rational that) {
        return new Rational(this.numerator*that.numerator, this.denominator*that.denominator);
    }

    public Rational divide(Rational that) {
        return new Rational(this.numerator*that.denominator, this.denominator*that.numerator);
    }

    public Rational negate() {
        return new Rational(-this.numerator, this.denominator);
    }
    private void normalize() {
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        int divisor = 2;
        while (Math.abs(numerator) != 1 && denominator != 1 && divisor <= Math.abs(numerator) && divisor <= denominator) {
            if (numerator % divisor == 0 && denominator % divisor == 0) {
                numerator /= divisor;
                denominator /= divisor;
                divisor = 2;
                continue;
            }
            divisor++;
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(numerator);
        if (denominator != 1) {
            sb.append("/").append(denominator);
        }
        return sb.toString();
    }
}
