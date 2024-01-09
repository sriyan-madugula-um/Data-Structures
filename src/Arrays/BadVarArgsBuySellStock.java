package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class BadVarArgsBuySellStock { //did it with lists later, still issue //buysellstock
    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int count = 0;
        int complete = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] < prices[i]) {
                int[] temp = new int[i - complete + 1];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = prices[complete];
                    complete++;
                }
                map.put(count, temp);
                count++;
            }
        }
        int l = 0;
        int[] temp = new int[prices.length - complete];
        for (int k = complete; k < prices.length; k++) {
            temp[l] = prices[complete];
            l++;
            complete++;
        }
        map.put(count, temp);
        /*for(int key : map.keySet())
        {
            System.out.println(key);
        }
        for(int[] value : map.values())
        {
            System.out.println(Arrays.toString(value));
        }*/ //below is only part i cant automate
        return rec(fee, map.getOrDefault(0, new int[0]), map.getOrDefault(1, new int[0]), map.getOrDefault(2, new int[0]));
    }

    public static int[] merge(int[]... nums) {
        if (null == nums) {
            return null;
        }
        int size = 0;
        for (int[] num : nums) {
            size += num.length;
        }
        int[] result = new int[size];
        int j = 0;
        for (int[] num : nums) {
            for (int i = 0; i < num.length; i++) {
                result[j] = num[i];
                j++;
            }
        }
        return result;
    }

    public static int profit(int[] array, int fee) {
        int res = array[array.length - 1] - array[0] - fee;
        return Math.max(res, 0); //returns res unless it's negative - in that case, returns 0
    }

    public static int rec(int fee, int[]... nums) {
        if (null == nums) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length == 0) {
                continue;
            }
            int[][] temp1 = Arrays.copyOfRange(nums, 0, i + 1);
            int[][] temp2 = Arrays.copyOfRange(nums, i + 1, nums.length);
            for (int[] j : temp1) {
                System.out.print(Arrays.toString(j) + "  ");
            }
            System.out.println(i);
            System.out.println(" ");
            for (int[] k : temp2) {
                System.out.print(Arrays.toString(k) + "  ");
            }


            //maxProfit = Math.max(maxProfit, profit(merge(Arrays.copyOfRange(nums, 0, i+1)), fee) + rec(fee, Arrays.copyOfRange(nums, i+1, nums.length)));
        }
        return maxProfit;
    }
}
