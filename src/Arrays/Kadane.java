package Arrays;

public class Kadane {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(nums));
    }

    public static int maxSubArraySum(int[] nums) {
        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int num : nums) {
            max_ending_here = max_ending_here + num;
            max_so_far = Math.max(max_ending_here, max_so_far);
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }
}
