package 笔试.携程.test;

public class Main {
    public static void main(String[] args) {
        int num1 = 1440;
        int num2 = 10072;
        System.out.println(countDivisibleWays(num1));
        System.out.println(countDivisibleWays(num2));
    }

    public static int countDivisibleWays(int num) {
        return countDivisibleWaysHelper(num, 0, 0);
    }

    public static int countDivisibleWaysHelper(int remaining, int current, int count) {
        if (remaining == 0 && current % 72 == 0) {
            return 1;
        }
        if (remaining == 0) {
            return 0;
        }

        int ways = 0;
        for (int i = 1; i <= 3; i++) {
            int nextSegment = Integer.parseInt(Integer.toString(remaining).substring(0, i));
            ways += countDivisibleWaysHelper(Integer.parseInt(Integer.toString(remaining).substring(i)), current + nextSegment, count + 1);
        }

        return ways;
    }
}

