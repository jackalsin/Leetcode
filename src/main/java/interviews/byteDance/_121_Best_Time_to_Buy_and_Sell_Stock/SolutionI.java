package interviews.byteDance._121_Best_Time_to_Buy_and_Sell_Stock;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int minPriceSoFar = prices[0], max = 0;
    for (int price : prices) {
      max = Math.max(max, price - minPriceSoFar);
      minPriceSoFar = Math.min(minPriceSoFar, price);
    }
    return max;
  }
}
