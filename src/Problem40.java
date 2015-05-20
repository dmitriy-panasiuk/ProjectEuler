public class Problem40 {
    public static void main(String[] args) {
        int n = 1;
        int digit = 0;
        String s = "";
        while (n < 100000) {
            s += n;
            n++;
        }
        System.out.println(s.charAt(0) + " " + s.charAt(9) + " " + s.charAt(99) + " " + s.charAt(999) + " " + s.charAt(9999) + " " + s.charAt(99999) + " " + s.charAt(999999));
    }
}
