package Arrays;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(nums).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> eachOne = new ArrayList<>();
                    eachOne.add(nums[i]);
                    eachOne.add(nums[j]);
                    eachOne.add(nums[k]);
                    //eachOne.sort(Comparator.naturalOrder());
                    if (!result.contains(eachOne)) {
                        result.add(eachOne);
                    }
                    j++;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
