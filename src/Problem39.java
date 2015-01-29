import java.util.ArrayList;

/*If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions
 for p = 120.
        {20,48,52}, {24,45,51}, {30,40,50}
For which value of p ≤ 1000, is the number of solutions maximised?*/
public class Problem39 {
    public static void main(String[] args) {
        int NN = 120;
        ArrayList[] s = new ArrayList[NN+1];
        for (int i = 0; i < s.length; i++) {
            s[i] = new ArrayList();
        }
        Triplet t;
        int m = 2, n = 1;
        for (m = 2; true; m++) {
            if (m * m + m * n > NN) break;
            for (n = 1; n < m; n++) {
                t = new Problem39().new Triplet(m, n);
                if (t.getPerimeter() > NN) {
                    break;
                }
                s[t.getPerimeter()].add(t.toString());
            }
        }
        System.out.println();
    }

    class Triplet {
        private int m, n;

        Triplet(int m , int n) {
            if (m <= n) throw new IllegalArgumentException();
            this.m = m;
            this.n = n;
        }

        int getPerimeter() {
            return 2 * (m * m + m * n);
        }

        int[] getTriplet() {
            return new int[] {m * m - n * n, 2 * m * n, m * m + n * n};
        }

        public String toString() {
            int[] triplet = getTriplet();
            return triplet[0] + " " + triplet[1] + " " + triplet[2];
        }
    }
}
