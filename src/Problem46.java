/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a
 * square.
 * <p/>
 * 9 = 7 + 2×12
 * 15 = 7 + 2×22
 * 21 = 3 + 2×32
 * 25 = 7 + 2×32
 * 27 = 19 + 2×22
 * 33 = 31 + 2×12
 * <p/>
 * It turns out that the conjecture was false.
 * <p/>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class Problem46 {
    public static void main(String[] args) {
        Seed seed = new Seed();
        int n = 3, k, prime;
        boolean primeFound;

        while (true) {
            if (!seed.isPrime(n)) {
                primeFound = false;
                k = 1;
                prime = n - 2 * k * k;
                while (prime > 0) {
                    if (seed.isPrime(prime)) {
                        primeFound = true;
                        break;
                    }
                    k++;
                    prime = n - 2 * k * k;
                }
                if (!primeFound) {
                    System.out.println(n);
                    break;
                }
            }
            n+=2;
        }
    }
}
