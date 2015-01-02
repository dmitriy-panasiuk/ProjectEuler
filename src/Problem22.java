/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
by its alphabetical position in the list to obtain a name score.
For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
What is the total of all the name scores in the file?
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem22 {
    private static final String FILENAME = "problem22.txt";

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TreeMap<String, Integer> map = init(FILENAME);
        System.out.println(getTotalScore(map));
//        List<String> l = initAlt(FILENAME);
//        System.out.println(getTotalScoreAlt(l));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static int getTotalScore(TreeMap<String, Integer> map) {
        int i = 1;
        int sum = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            sum += i * e.getValue();
            i++;
        }

        return sum;
    }

    private static TreeMap<String, Integer> init(String filename) {
        TreeMap<String, Integer> strings = new TreeMap<String, Integer>();
        String str;
        try {
            Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\resources\\" + filename));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                str = scanner.next().replaceAll("\"", "");
                strings.put(str, alphaValue(str));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return strings;
    }

    private static int alphaValue(String str) {
        int value = 0;
        for (char c : str.toCharArray()) {
            value += charValue(c);
        }
        return value;
    }

    private static int charValue(char c) {
        return (int)c - 64;
    }

    //Alternative approach
    private static List<String> initAlt(String filename) {
        List<String> strings = new ArrayList<String>();
        String str;
        try {
            Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\resources\\" + filename));
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                str = scanner.next().replaceAll("\"", "");
                strings.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return strings;
    }

    private static int getTotalScoreAlt(List<String> strings) {
        int sum = 0;

        Collections.sort(strings);
        for (int i = 0; i < strings.size(); i++) {
            sum += (i + 1) * alphaValue(strings.get(i));
        }
        return sum;
    }
}
