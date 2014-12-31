/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

        3
        7 4
        2 4 6
        8 5 9 3

        That is, 3 + 7 + 4 + 9 = 23.

        Find the maximum total from top to bottom of the triangle below:

        75
        95 64
        17 47 82
        18 35 87 10
        20 04 82 47 65
        19 01 23 75 03 34
        88 02 77 73 07 63 67
        99 65 04 28 06 16 70 92
        41 41 26 56 83 40 80 70 33
        41 48 72 33 47 32 37 16 94 29
        53 71 44 65 25 43 91 52 97 51 14
        70 11 33 28 77 73 17 78 39 68 17 57
        91 71 52 38 17 14 91 43 58 50 27 29 48
        63 66 04 68 89 53 67 30 73 16 69 87 40 31
        04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

        NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
*/

import java.io.*;

public class Problem18 {
    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 15;
        int[][] numbers = new int[15][];
        String filename = "problem18.txt";

        initNumbers(numbers, filename);
        getTotal(numbers);
        System.out.println(max(numbers[numbers.length - 1]));
    }

    private static void initNumbers(int[][] numbers, String filename) {
        File f = new File(System.getProperty("user.dir") + "\\resources\\" + filename);
        String s;
        int counter = 0;
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            while ((s = r.readLine()) != null) {
                numbers[counter++] = parseStr(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] parseStr(String line) {
        String[] strings = line.split(" ");
        int[] numbers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }
        return numbers;
    }

    private static void getTotal(int[][] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            numbers[i][0] += numbers[i - 1][0];
            for (int j = 1; j < numbers[i].length - 1; j++) {
                numbers[i][j] += maxOfTwo(numbers[i - 1][j - 1], numbers[i - 1][j]);
            }
            numbers[i][numbers[i].length - 1] += numbers[i - 1][numbers[i - 1].length - 1];
        }
    }

    private static int maxOfTwo(int a, int b) {
        if (a > b) return a;
        return b;
    }

    private static int max(int[] vector) {
        int max = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > max) {
                max = vector[i];
            }
        }

        return max;
    }
}
