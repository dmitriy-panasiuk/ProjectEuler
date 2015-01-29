import java.util.ArrayList;

/*If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions
 for p = 120.
        {20,48,52}, {24,45,51}, {30,40,50}
For which value of p ≤ 1000, is the number of solutions maximised?*/
public class Problem39 {
    public static void main(String[] args) {
        int NN = 1000;
        ArrayList[] s = new ArrayList[NN + 1];
        int m, n = 1, perimeter, k, max = 0, indexMax = 0;
        for (int i = 0; i < s.length; i++) {
            s[i] = new ArrayList();
        }
        Triplet t;

        for (m = 2; true; m++) {
            if (m * m + m * n > NN) break;
            for (n = 1; n < m; n++) {
                if ((m - n) % 2 > 0 && isCoPrime(m, n)) {
                    t = new Problem39().new Triplet(m, n);
                    if (t.getPerimeter() > NN) {
                        break;
                    }
                    k = 1;
                    perimeter = t.getPerimeter();
                    while (perimeter * k <= NN) {
                        s[perimeter * k].add(t.toString() + " * " + k);
                        k++;
                    }
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i].size() > max) {
                max = s[i].size();
                indexMax = i;
            }
        }
        System.out.println(indexMax);
    }

    private static boolean isCoPrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    class Triplet {
        private int m, n;

        Triplet(int m, int n) {
            if (m <= n) throw new IllegalArgumentException();
            this.m = m;
            this.n = n;
        }

        int getPerimeter() {
            return 2 * (m * m + m * n);
        }

        int[] getTriplet() {
            return new int[]{m * m - n * n, 2 * m * n, m * m + n * n};
        }

        public String toString() {
            int[] triplet = getTriplet();
            return triplet[0] + " " + triplet[1] + " " + triplet[2];
        }
    }
}
