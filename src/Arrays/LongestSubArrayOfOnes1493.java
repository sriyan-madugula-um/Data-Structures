package Arrays;

import java.util.*;

public class LongestSubArrayOfOnes1493 { //Longest Subarray of 1's After Deleting Exactly One Element
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        System.out.println(longestSubarray1(nums));
        System.out.println(longestSubarrayOne(nums));
        System.out.println(longestSubarray(nums));
    }

    public static int longestSubarray1(int[] nums) {
        //brute force: delete every index and count number of 1's remaining, return index associated with the largest count
        //optimized for certain cases but still slow
        int largestCount = Integer.MIN_VALUE;
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        if (!numbers.contains(0)) //optimized
        {
            return numbers.size() - 1;
        }
        if (!numbers.contains(1)) //optimized
        {
            return 0;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == 1) //optimized
            {
                continue;
            }
            int count = 0;
            int largeCount = 0;
            int removed = numbers.get(i);
            numbers.remove(i);
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == 1) {
                    count++;
                    largeCount = Math.max(largeCount, count);
                } else {
                    count = 0;
                }
            }
            largestCount = Math.max(largestCount, largeCount);
            numbers.add(i, removed);
        }
        return largestCount;
    }

    public static int longestSubarrayOne(int[] nums) {
        int left = 0;
        int right = 0;
        int largestCount = 0;
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        if (!numbers.contains(0)) {
            return numbers.size() - 1;
        }
        if (!numbers.contains(1)) {
            return 0;
        }
        int j = 0;
        while (j < numbers.size()) {
            if (numbers.get(j) == 0) {
                break;
            }
            j++;
        }
        left = j;
        for (int i = j + 1; i < numbers.size(); i++) {
            int count = 0;
            if (numbers.get(i) == 1) {
                right++;
            }
            if (numbers.get(i) == 0 || i == numbers.size() - 1) {
                count = left + right;
                largestCount = Math.max(count, largestCount);
                left = right;
                right = 0;
            }
        }
        return largestCount;
    }

    public static int longestSubarray(int[] nums) { // 0,1,1,1,0,1,1,0,1
        int largestCount = Integer.MIN_VALUE;
        int start = 0;
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = prev + 1;
                prev = i;
            }
            largestCount = Math.max(largestCount, i - start);
        }
        return largestCount;
    }
}
