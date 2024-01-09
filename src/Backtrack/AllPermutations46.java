package Backtrack;

import java.util.*;

public class AllPermutations46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        //System.out.println(result.size());
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            if (!result.contains(curr))
                result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(nums, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
