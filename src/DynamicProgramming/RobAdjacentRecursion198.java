package DynamicProgramming;

import java.util.*;

public class RobAdjacentRecursion198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        //System.out.println(robber(nums));
        System.out.println(robBest(nums));
    }

    public static int robber(int[] nums) {
        int[] memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    public static int rob(int[] nums, int i, int[] memo) {
        if (i > nums.length - 1) {
            return 0;
        }
        if (memo[i] >= 0) //not -1
        {
            return memo[i];
        }
        int result = Math.max(rob(nums, i + 2, memo) + nums[i], rob(nums, i + 1, memo));
        memo[i] = result; //store in memory
        return result;
        // return memo[i] = Math.max(rob(nums, i + 2, memo) + nums[i], rob(nums, i + 1, memo));
    }

    public static int robBest(int[] nums) { //no recursion needed
        if (nums.length == 0) {
            return 0;
        }
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
