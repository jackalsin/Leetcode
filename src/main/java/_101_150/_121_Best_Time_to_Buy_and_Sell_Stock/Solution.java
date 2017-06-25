package _101_150._121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * @author jacka
 * @version 1.0 on 6/24/2017.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int curBuyPrice = prices[0];
    int curMaxBias = 0;
    for (int i = 1; i < prices.length; i++) {
      int curStockPrice = prices[i];
      if (curStockPrice <= curBuyPrice) {
        curBuyPrice = curStockPrice;
      } else {
        curMaxBias = Math.max(curMaxBias, curStockPrice - curBuyPrice);
      }
    }
    return curMaxBias;
  }
}
