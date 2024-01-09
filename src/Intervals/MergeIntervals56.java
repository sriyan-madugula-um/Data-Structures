package Intervals;

import Matrix.RotateImageMatrix48;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals56 { //using linkedlists is faster
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {0, 5}};
        int[][] result = merge1(intervals);
        int[][] res = merge2(intervals); //faster
        RotateImageMatrix48.print2D(result);
        System.out.println();
        RotateImageMatrix48.print2D(res);
    }

    private static int[][] merge2(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0])); //sort first numbers using lambda expression
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] num : nums) {
            if (result.isEmpty() || result.getLast()[1] < num[0]) {
                result.add(num);
            } else {
                //result.getLast()[0] = Math.min(result.getLast()[0], num[0]); //not needed cuz already sorted first numbers
                result.getLast()[1] = Math.max(result.getLast()[1], num[1]);
            }
        }
        return result.toArray(new int[result.size()][]); //convert linkedList back to int[][]
    }

    public static int[][] merge1(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i][1] >= nums[i + 1][0] && nums[i][0] <= nums[i + 1][1]) {
                int[][] left = new int[i][2]; //array of everything left of merge point
                for (int j = 0; j < i; j++) {
                    left[j][0] = nums[j][0];
                    left[j][1] = nums[j][1];
                }
                int[][] right = new int[nums.length - i - 2][2]; //array of everything right of merge point
                int n = i + 2;
                int r = 0;
                while (n < nums.length) {
                    right[r][0] = nums[n][0];
                    right[r][1] = nums[n][1];
                    r++;
                    n++;
                }
                int[][] merged = new int[1][2]; //2 arrays merged into one
                merged[0][0] = Math.min(nums[i][0], nums[i + 1][0]);
                merged[0][1] = Math.max(nums[i][1], nums[i + 1][1]);
                int[][] result = combine(left, merged, right);
                return merge1(result);
            }
        }
        return nums;
    }

    private static int[][] combine(int[][] left, int[][] merged, int[][] right) { //left, merged, and right have same # of columns (2)
        int[][] result = new int[left.length + merged.length + right.length][2];

        int l = 0;
        int r = 0;
        while (l < left.length) {
            result[r][0] = left[l][0];
            result[r][1] = left[l][1];
            r++;
            l++;
        }
        int m = 0;
        while (m < merged.length) {
            result[r][0] = merged[m][0];
            result[r][1] = merged[m][1];
            r++;
            m++;
        }
        int ri = 0;
        while (ri < right.length) {
            result[r][0] = right[ri][0];
            result[r][1] = right[ri][1];
            r++;
            ri++;
        }

        return result;
    }
}
