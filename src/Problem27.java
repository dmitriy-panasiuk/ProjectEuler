import java.util.HashSet;
import java.util.Set;

/*
Euler discovered the remarkable quadratic formula:
n² + n + 41
It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However,
when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
divisible by 41.
The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes for the consecutive values n = 0 to 79.
 The product of the coefficients, −79 and 1601, is −126479.
Considering quadratics of the form:
n² + an + b, where |a| < 1000 and |b| < 1000
where |n| is the modulus/absolute value of n
e.g. |11| = 11 and |−4| = 4
Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes
 for consecutive values of n, starting with n = 0.
*/
public class Problem27 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Seed s = new Seed();
        int max = 0;
        int primeCount = 0;
        int abProduct = 0;
        for (int b = 2; b < 1000; b++) {
            if (!s.isPrime(b))
                continue;
            for (int a = -b; a < 1000; a+=2) {
                /*if (a < (-b + 1)) {
                    continue;
                }*/
                primeCount = new Formula(a, b, s).primeCount();
                if (primeCount > max) {
                    max = primeCount;
                    abProduct = a * b;
                    System.out.println("a = " + a + " b = " + b + " primes = " + primeCount);
                }
            }
        }
        System.out.println(abProduct);
        System.out.println(System.currentTimeMillis() - start);
    }
}

class Formula {
    private int a;
    private int b;
    private Seed seed;

    public Formula(int a, int b, Seed seed) {
        this.a = a;
        this.b = b;
        this.seed = seed;
    }

    public int primeCount() {
        int count = 0;
        int currentResult = this.b;
        while (seed.isPrime(currentResult)) {
            count++;
            currentResult = count * count + this.a * count + this.b;
        }

        return count;
    }
}

class Seed {
    private Set<Integer> primes = new HashSet<Integer>();
    private int upper = 2;
    public Seed() {
        fill(1000);
        this.upper = 1000;
    }

    private void fill(int n) {
        for (int i = upper; i <= n; i++) {
            if (nextPrime(i)) {
                primes.add(i);
            }
        }
    }

    private boolean nextPrime(int n) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrime(int n) {
        fill(n);
        return primes.contains(n) || primes.contains(-n);
    }
}
