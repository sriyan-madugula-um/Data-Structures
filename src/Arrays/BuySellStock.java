package Arrays;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(maxProfit(prices, fee));
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < n; i++) {
            //System.out.print(buy[i-1] + ", ");
            //System.out.print(sell[i-1] - prices[i]);
            //System.out.print("     |     ");
            //System.out.print(sell[i-1] + ", ");
            //System.out.print(buy[i-1] + prices[i] - fee);
            //System.out.println();
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]); //tracking max profits at each index //didn't buy, did buy - if you bought at previous index, you cannot buy at current index
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee); //didn't sell, did sell
        }
        //System.out.println(Arrays.toString(buy));
        //System.out.println(Arrays.toString(sell));
        return sell[n - 1];
    }
}
