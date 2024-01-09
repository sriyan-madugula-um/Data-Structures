package Arrays;

import java.util.Arrays;

public class RotateArray { //shift right k number of times
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (n == 0 || n == k || k == 0) {
            return;
        }
        int count = 0;
        int start = 0;
        int current = 0; //index to move prev
        int prev = nums[0];
        while (count < n) {
            current = (current + k) % n;
            int temp = nums[current];
            nums[current] = prev;
            prev = temp;
            count++;

            if (current == start) {
                start++;
                current = start;
                prev = nums[start];
            }
        }
    }
}
