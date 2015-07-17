/*Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
        If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called
        amicable numbers.
        For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
        The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
        Evaluate the sum of all the amicable numbers under 10000.*/

public class Problem21 {
    private static int N = 10000;
    public static void main(String[] args) {
        System.out.println(sumOfDivisors(N));
        System.out.println(sumOfAmicableNumbers(N));
    }

    private static int sumOfAmicableNumbers(int n) {
        int[] numbers = new int[n];
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = sumOfDivisors(i);
        }

        return sum(numbers);
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < N && i == numbers[numbers[i]] && numbers[i] != i && i < numbers[i]) {
                sum += i + numbers[i];
            }
        }

        return sum;
    }

    private static int sumOfDivisors(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }

        return sum;
    }
}
