package _701_750._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
  public int maxProfit(int[] prices, int fee) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int days = prices.length, buy[] = new int[days], sell[] = new int[days];
    buy[0] = -prices[0];

    for (int i = 1; i < prices.length; i++) {
      buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
      sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
    }

//    System.out.println(Arrays.toString(sell));
//    System.out.println(Arrays.toString(buy));
    return sell[days - 1];
  }
}
