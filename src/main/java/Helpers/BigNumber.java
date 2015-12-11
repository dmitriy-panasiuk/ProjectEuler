package Helpers;

import java.util.ArrayList;
import java.util.List;

public class BigNumber {
    private List<Integer> digits = new ArrayList<>();

    public BigNumber(int n) {
        digits.add(n);
    }

    private BigNumber(List<Integer> n) {
        this.digits = n;
    }

    public BigNumber add(BigNumber that) {
        List<Integer> result = new ArrayList<>();
        int limit = Math.max(this.digitCount(), that.digitCount());
        int a, b;

        for (int i = 0; i < limit; i++) {
            if (i < this.digitCount()) {
                a = this.digits.get(i);
            } else {
                a = 0;
            }
            if (i < that.digitCount()) {
                b = that.digits.get(i);
            } else {
                b = 0;
            }
            result.add(i, a + b);
        }
        normalize(result);

        return new BigNumber(result);
    }

    private void normalize(List<Integer> number) {
        for (int i = 0; i < number.size() - 1; i++) {
            number.set(i + 1, number.get(i) / 10 + number.get(i + 1));
            number.set(i, number.get(i) % 10);
        }
        while (number.get(number.size() - 1) >= 10) {
            number.add(number.get(number.size() - 1) / 10);
            number.set(number.size() - 2, number.get(number.size() - 2) % 10);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = digits.size() - 1; i >= 0; i--) {
            sb.append(digits.get(i));
        }

        return sb.toString();
    }

    public int digitCount() {
        return digits.size();
    }
}
