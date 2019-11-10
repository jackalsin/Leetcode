package interviews.oracle._122_Best_Time_to_Buy_and_Sell_Stock_II;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    final int n = prices.length;
    int sum = 0, prev = prices[0];
    for (int i = 1; i < n; ++i) {
      final int add = Math.max(0, prices[i] - prev);
      sum += add;
      prev = prices[i];
    }
    return sum;
  }
}
