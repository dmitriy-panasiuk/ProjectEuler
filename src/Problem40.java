/*An irrational decimal fraction is created by concatenating the positive integers:

        0.123456789101112131415161718192021...

        It can be seen that the 12th digit of the fractional part is 1.

        If dn represents the nth digit of the fractional part, find the value of the following expression.

        d1 ? d10 ? d100 ? d1000 ? d10000 ? d100000 ? d1000000
*/
public class Problem40 {
    public static void main(String[] args) {
        int n = 1;
        int digit = 0;
        String s = "";
        while (n < 200000) {
            s += n;
            n++;
        }
        System.out.println(s.charAt(0) + " " + s.charAt(9) + " " + s.charAt(99) + " " + s.charAt(999) + " " + s.charAt(9999) + " " + s.charAt(99999) + " " + s.charAt(999999));
    }
}
