package DynamicProgramming;

import java.util.*;

public class CoinChange322 {
    public static void main(String[] args) {
        int[] coins = {3, 5, 7};
        int amount = 7;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                //System.out.println(Arrays.toString(dp));
            }
        }

        if (dp[amount] > amount) //dp[amount] never changed and is still amount+1
        {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
