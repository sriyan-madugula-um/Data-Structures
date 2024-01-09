package Arrays;

import java.util.*;

public class ThreeSum2 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> eachOne = new ArrayList<>();
                        eachOne.add(nums[i]);
                        eachOne.add(nums[j]);
                        eachOne.add(nums[k]);
                        eachOne.sort(Comparator.naturalOrder());
                        if (!result.contains(eachOne)) {
                            result.add(eachOne);
                        }
                    }
                }
            }
        }
        return result;
    }
}
