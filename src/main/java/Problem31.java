import java.util.ArrayList;
import java.util.List;

/*In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
        1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:
        1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?*/
public class Problem31 {
    private static final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    private static final List<List<Integer>> ways = new ArrayList<List<Integer>>();

    public static void main(String[] args) {
        getWays(coins, 200, 0, new ArrayList<Integer>(), 0);
        for (List<Integer> way : ways) {
            System.out.println(way);
        }
        System.out.println(ways.size());
    }

    private static void getWays(int[] coins, int sum, int currentSum, List<Integer> way, int level) {
        int newSum = 0;
        for (int i = level; i < coins.length; i++) {
            newSum = currentSum + coins[i];
            if (newSum < sum ) {
                way.add(coins[i]);
                getWays(coins, sum, newSum, way, i);
                way.remove(way.size()-1);
            } else if (newSum == sum) {
                way.add(coins[i]);
                ways.add(new ArrayList<Integer>(way));
                way.remove(way.size()-1);
            } else {
                return;
            }
        }
    }
}
