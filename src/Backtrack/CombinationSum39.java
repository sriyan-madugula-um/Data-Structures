package Backtrack;

import java.util.*;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] nums = {7, 3, 2};
        int target = 18;
        System.out.println(combSum(nums, target));
    }

    public static List<List<Integer>> combSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, target, 0);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> result, int target, int start) {
        if (sum(curr) >= target) {
            if (sum(curr) == target) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(nums, curr, result, target, i);
            curr.remove(curr.size() - 1);
        }
    }

    public static int sum(List<Integer> curr) {
        int sum = 0;
        for (int each : curr) {
            sum += each;
        }
        return sum;
    }
}
