package Arrays;

import java.util.*;

public class TwoSum1 {
    public static void main(String[] args) {
        int[] nums = {2, 11, 4, 3};
        System.out.println(Arrays.toString(twoSum(nums, 6))); //assume exactly one solution
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>(); //value, index

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        return new int[]{}; //no solution
    }
}
