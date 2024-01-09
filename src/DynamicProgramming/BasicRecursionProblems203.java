package DynamicProgramming;

import java.sql.SQLOutput;

public class BasicRecursionProblems203 {
    public static void main(String[] args) {
        int n = 4;
//        System.out.println(climbStairs(n, 0)); // count how many ways you can climb stairs if you can go one or two at a time
//        System.out.println(goDownStairs(n)); // start at top, go down by one or two stairs
//        System.out.println(outfits(n)); // Katie's Pandemic Outfits
//        System.out.println(bits00(n)); // how many bits of length n have 00 in them
        for (int i = 0; i < 7; i++) {
            System.out.println(pastry(i));
        }
    }

    private static int climbStairs(int n, int stair) {
        if (stair == n) { // need 2 base cases
            return 1; // 1 way to do nothing at top stair
        }
        if (stair == n - 1) {
            return 1; // 1 way to climb one stair
        }
        return climbStairs(n, stair + 1) + climbStairs(n, stair + 2);
    }

    private static int goDownStairs(int n) {
        if (n == 0) { // need 2 base cases
            return 1; // 1 way to do nothing at bottom stair
        }
        if (n == 1) {
            return 1; // 1 way to go down one stair
        }
        return goDownStairs(n - 1) + goDownStairs(n - 2);
    }

    private static int outfits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 3;
        }
        return 2 * outfits(n - 1) + 2 * outfits(n - 2);
    }

    private static int bits00(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        return (int) (Math.pow(2, n - 2)) + bits00(n - 1) + bits00(n - 2); //first one doesn't have rec b/c we already found 00
    }

    private static int pastry(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
//        if (n == 3) {
//            return 2;
//        }
        return pastry(n - 2) + 2 * pastry(n - 3);
    }
}
