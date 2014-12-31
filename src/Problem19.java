

/*
You are given the following information, but you may prefer to do some research for yourself.

        1 Jan 1900 was a Monday.
        Thirty days has September,
        April, June and November.
        All the rest have thirty-one,
        Saving February alone,
        Which has twenty-eight, rain or shine.
        And on leap years, twenty-nine.
        A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

        How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
*/

public class Problem19 {
    private static int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
    private static String[] monthsNames = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    private static int startYear = 1900;
    private static int endYear = 2000;

    public static void main(String[] args) {
        System.out.println(mondaysCount());
    }

    private static boolean isLeap(int year) {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    private static int mondaysCount() {
        int days = 1;
        int mondays = 1;
        int year = startYear;
        while (year <= endYear) {
            for (int i = 0; i < months.length; i++) {
                days += months[i];
                if (i == 1 && isLeap(year))
                    days++;
                if (days % 7 == 0) {
                    mondays++;
                    System.out.println("1st of " + monthsNames[(i + 1) % 12] + " " + year + " is sunday");
                }
            }
            year++;
        }

        return mondays;
    }
}
