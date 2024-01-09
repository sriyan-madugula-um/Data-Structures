package Arrays;

public class MaxProductSubarray { //Kadane's algorithm but with multiplication rather than addition
    public static void main(String[] args) {
        int[] nums = {-2, 0, -1}; //0's are difficult to handle
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {

        int maxProduct = Integer.MIN_VALUE; //where we store final answer
        int product = 1; // what we use to find products of subarrays (left and right)

        for (int i = 0; i < nums.length; i++) {
            product = product * nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) {
                product = 1; //restart
            }
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product = product * nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) {
                product = 1; //restart
            }
        }

        return maxProduct;
    }
}
