package Arrays;

import java.util.HashMap;

public class LongestConsecutiveSequence128 { //make O(n)
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        int maxCount = 1;
        HashMap<Integer, Integer> map = new HashMap<>(); //can also use hashset
        for (int num : nums) {
            map.put(num, num);
        }
        for (int num : nums) {
            int count = 1;
            if (!map.containsKey(num - count)) //could be a starting point for sequence
                while (map.containsKey(num + count)) {
                    map.remove(num + count); //not needed
                    count++;
                }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
}
