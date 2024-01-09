package BinarySearch;

public class BinarySearch33 { //Olog(n), another easier example #153
    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 6};
        int target = 4;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > nums[r] && target < nums[m] && target > nums[r]) {
                r = m;
            }
            if (nums[m] > nums[r] && target > nums[m]) {
                l = m + 1;
            }
            if (nums[m] > nums[r] && target < nums[m] && target < nums[r]) {
                l = m + 1;
            }
            if (nums[m] < nums[r] && target < nums[m]) {
                r = m;
            }
            if (nums[m] < nums[r] && target > nums[m] && target < nums[r]) {
                l = m + 1;
            }
            if (nums[m] < nums[r] && target > nums[m] && target > nums[r]) {
                r = m;
            }
        }
        return -1;
    }
}
