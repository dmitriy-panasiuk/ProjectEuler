/*We have numbers 1, 3, 4 and 6. Create an expression using any elementary operators (+, -, *, /),
containing only these numbers, exactly once each, such that the result is 24.*/
import Helpers.Combinator;

import java.util.*;

public class InterviewTask {
    public static void main(String[] args) {
        List<Character> numbers = Arrays.asList('1', '3', '3');
        Rational r = new Rational(2);
        /*ReversePolishNotation example = new ReversePolishNotation(Arrays.asList(new Rational(1), new Rational(2), '/', new Rational(3), '/'));
        System.out.println(example);
        System.out.println(example.evaluate());*/
        System.out.println(getOperandsPosition(4));
    }

    private static List<List<Integer>> getOperandsPosition(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> initialPosition = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++) {
            initialPosition.add(0);
        }
        initialPosition.set(n - 2, n - 1);
        getNextOperand(initialPosition, result, 0);
        return result;
    }

    private static void getNextOperand(List<Integer> current, List<List<Integer>> result, int level) {
        result.add(new ArrayList<Integer>(current));
        int index = current.size() - 1 - level;
        int value = current.get(index);
        for (int i = 0; index > 0 && i < value; i++) {
            if (level == 0 && i == 0)
                continue;
            current.set(index - 1, current.get(index - 1) + 1);
            current.set(index, current.get(index) - 1);
            getNextOperand(new ArrayList<Integer>(current), result, level + 1);
        }
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

class ReversePolishNotation {
    Deque<Object> expression;
    ReversePolishNotation(List<Object> expression) {
        this.expression = new ArrayDeque<Object>(expression);
    }

    public Rational evaluate() {
        Deque<Rational> stack = new ArrayDeque<Rational>();
        Deque<Object> copyOfExpression = new ArrayDeque<Object>(expression);
        Object nextElement;
        Rational firstOperand, secondOperand;
        char operator;

        while (!copyOfExpression.isEmpty()) {
            nextElement = copyOfExpression.pop();
            if (nextElement instanceof Rational) {
                stack.addFirst((Rational)nextElement);
            } else {
                operator = (Character)nextElement;
                firstOperand = stack.pop();
                secondOperand = stack.pop();
                switch (operator) {
                    case '+':
                        stack.addFirst(secondOperand.add(firstOperand));
                        break;
                    case '-':
                        stack.addFirst(secondOperand.subtract(firstOperand));
                        break;
                    case '*':
                        stack.addFirst(secondOperand.multiply(firstOperand));
                        break;
                    case '/':
                        stack.addFirst(secondOperand.divide(firstOperand));
                        break;
                    default:
                        throw new IllegalArgumentException("No such operation " + operator);
                }
            }
        }
        if (stack.size() > 1) throw new IllegalStateException("Invalid state of expression in the end of evaluation" + stack);

        return stack.pop();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Deque<Rational> stack = new ArrayDeque<Rational>();
        Deque<Object> copyOfExpression = new ArrayDeque<Object>(expression);
        Object nextElement;
        Rational firstOperand, secondOperand;
        char operator;

        //sb.append(copyOfExpression.pop());
        while (!copyOfExpression.isEmpty()) {
            nextElement = copyOfExpression.pop();
            if (nextElement instanceof Rational) {
                stack.addFirst((Rational)nextElement);
            } else {
                operator = (Character)nextElement;
                firstOperand = stack.pop();
                if (!stack.isEmpty()) {
                    secondOperand = stack.pop();
                    sb = sb.append('(').append(secondOperand).append(operator).append(firstOperand).append(')');
                } else {
                    sb = sb.insert(0, '(').append(operator).append(firstOperand).append(')');
                }
            }
        }
        if (stack.size() > 1) throw new IllegalStateException("Invalid state of expression in the end of evaluation" + stack);
        return sb.toString();
    }
}