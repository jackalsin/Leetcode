package oracle._121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int min = Integer.MAX_VALUE, maxProfit = 0;
    for (int price : prices) {
      min = Math.min(min, price);
      maxProfit = Math.max(maxProfit, price - min);
    }
    return maxProfit;
  }
}
