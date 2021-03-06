/**
 Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:

 Triangle	 	Tn=n(n+1)/2	 	1, 3, 6, 10, 15, ...
 Pentagonal	 	Pn=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
 Hexagonal	 	Hn=n(2n−1)	 	1, 6, 15, 28, 45, ...
 It can be verified that T285 = P165 = H143 = 40755.

 Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem45 {
    public static void main(String[] args) {
        long n = 144,Pk;
        while (true) {
            Pk = n * (2 * n - 1);
            if (isPenta(Pk) && isTriangle(Pk)) {
                System.out.println(Pk);
                System.out.println(n);
                break;
            }
            n++;
        }
    }
    private static boolean isPenta(long x) {
        double penTest = (Math.sqrt(1 + 24 * x) + 1.0) / 6.0;
        return penTest == ((int)penTest);
    }

    private static boolean isTriangle(long n) {
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
