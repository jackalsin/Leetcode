package _301_350._309_Best_Time_to_Buy_and_Sell_Stock_withCool_down;

import java.util.Arrays;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/18/2017.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    final int len = prices.length;
    if (len == 0) return 0;
    final int[] s0 = new int[len]; // has stock -> can sell or rest
    final int[] s1 = new int[len]; // no stock and just sold -> can rest
    final int[] s2 = new int[len]; // no stock and last round no sell -> can buy or rest

    s0[0] = - prices[0];
    s1[0] = 0;
    s2[0] = 0;
    for (int i = 1; i < len; ++i) {
      s0[i] = Math.max(s0[i - 1], s2[i - 1] - prices[i]);
      s1[i] = s0[i - 1] + prices[i];
      s2[i] = Math.max(s1[i - 1], s2[i - 1]);
    }

    return Math.max(Math.max(s0[len - 1], s1[len - 1]), s2[len - 1]);
  }
}
