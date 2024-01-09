package Binary;

import java.util.*;

public class CountingBits338 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
        System.out.println(Arrays.toString(countBits1(n)));
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        ans[0] = 0;
        if (n == 0) {
            return ans;
        }
        ans[1] = 1;

        int count2power = 0;
        for (int i = 2; i < n + 1; i++) {
            if ((Math.log(i) / Math.log(2)) % 1 == 0) {
                count2power++;
            }
            ans[i] = ans[i - (int) Math.pow(2, count2power)] + 1;
        }

        return ans;
    }

    public static int[] countBits1(int n) {
        int[] ans = new int[n + 1];

        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i / 2] + i % 2; //similar logic to convertToNewBase class
            // i / 2 is the same as i >> 1 (move bits to the right by 1), i / (n+1) == i >> n
            // i % 2 is the same as i & 1 (&& of both bits must be 1), i % n == i % (2^n)
        }

        return ans;
    }
}
