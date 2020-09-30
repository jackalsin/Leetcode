package _0951_1000._956_Tallest_Billboard;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
public final class DpSolution implements Solution {
  /**
   * <a herf='https://leetcode.com/problems/tallest-billboard/discuss/203181/JavaC%2B%2BPython-DP-min(O(SN2)-O(3N2-*-N)'></a>
   */
  @Override
  public int tallestBillboard(int[] rods) {
    /*dp[d] 代表有一个pair {dp[d] + d, dp[d]}*/
    final int[] dp = new int[5001];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    for (int rod : rods) {
      final int[] prev = dp.clone();
      for (int d = 0; d + rod < 5001; ++d) {
        dp[d + rod] = Math.max(dp[d + rod], prev[d]);
        if (rod > d) {
          dp[rod - d] = Math.max(dp[rod - d], prev[d] + d);
        } else {
          dp[d - rod] = Math.max(dp[d - rod], prev[d] + rod);
        }
      } // end of for int d
//      System.out.println(Arrays.toString(dp));
    }
    return dp[0];
  }
}
