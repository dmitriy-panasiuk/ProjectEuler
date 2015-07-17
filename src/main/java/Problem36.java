import java.util.ArrayList;
import java.util.List;

/*The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
(Please note that the palindromic number, in either base, may not include leading zeros.)*/
public class Problem36 {
    public static void main(String[] args) {
        System.out.println(run());
        //System.out.println(isPali("17"));
    }

    private static int run() {
        int sum = 0;

        for (String n : palindromes()) {
            if (isPali(n)) {
                System.out.println(n);
                System.out.println(Integer.toBinaryString(Integer.parseInt(n)));
                sum += Integer.parseInt(n);
            }
        }

        return sum;
    }

    private static List<String> palindromes() {
        List<String> pals = new ArrayList<String>();
        for (char i = '1'; i <= '9'; i+=2) {
            pals.add(i+"");
        }
        for (char i = '1'; i <= '9'; i+=2) {
            pals.add("" + i + i);
        }
        for (char i = '1'; i <= '9'; i+=2) {
            for (char j = '0'; j <= '9'; j++) {
                pals.add("" + i + j + i);
            }
        }
        for (char j = '1'; j <= '9'; j+=2) {
            for (char i = '0'; i <= '9'; i ++) {
                pals.add("" + j + i + i + j);
            }
        }
        for (char i = '1'; i <= '9'; i+=2) {
            for (char j = '0'; j <= '9'; j++) {
                for (char k = '0'; k <= '9'; k++)
                    pals.add("" + i + j + k + j + i);
            }
        }
        for (char j = '1'; j <= '9'; j+=2) {
            for (char i = '0'; i <= '9'; i ++) {
                for (char k = '0'; k <= '9'; k++)
                pals.add("" + j + i + k + k + i + j);
            }
        }
        return pals;
    }

    private static boolean isPali(String n) {
        String binary = Integer.toBinaryString(Integer.parseInt(n));
        for (int i = 0, j = binary.length() - 1; i <= j; i++, j--) {
            if (binary.charAt(i) != binary.charAt(j))
                return false;
        }

        return true;
    }
}
