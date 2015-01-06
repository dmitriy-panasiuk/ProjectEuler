/*
The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly
believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits
in the numerator and denominator.
If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
*/
public class Problem33 {
    public static void main(String[] args) {
        int a,b,c_div, c_mod;
        for (a = 1; a < 10; a++) {
            for (b = 1; b < 10; b++) {
                /*c_mod = (a * b) % (10 * a - 9 * b);
                c_div = (a * b) / (10 * a - 9 * b);*/
                c_mod = ( 10 * a * b) % (9 * a + b);
                c_div = ( 10 * a * b) / (9 * a + b);

                if (c_mod == 0 && c_div > 0 && a < b) {
                    //System.out.println(a + "" + b + "/" + c_div + "" + a + " = " + b + "/" + c_div);
                    System.out.println(a + "" + b + "/" + b + "" + c_div + " = " + a + "/" + c_div);
                }
            }
        }
    }
}
