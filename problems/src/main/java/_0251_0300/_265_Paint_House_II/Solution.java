package _0251_0300._265_Paint_House_II;

import java.util.Arrays;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int COLORS = costs[0].length;
    if (COLORS == 0) return 0;
    int[] costsDp = new int[COLORS];
    int[] prevCostsDp = new int[COLORS];
    for (int col = 0; col < COLORS; ++col) {
      prevCostsDp[col] = costs[0][col];
    }
    Arrays.fill(costsDp, Integer.MAX_VALUE);
    for (int row = 1; row < costs.length; ++row) {
      for (int col = 0; col < COLORS; ++col) {
        for (int colorCol = 0; colorCol < COLORS; ++colorCol) {
          if (col != colorCol) {
            costsDp[colorCol] = Math.min(costsDp[colorCol], prevCostsDp[col] +
                costs[row][colorCol]);
          }
        }
      }
      System.arraycopy(costsDp, 0, prevCostsDp, 0, COLORS);
      Arrays.fill(costsDp, Integer.MAX_VALUE);
    }
    int min = Integer.MAX_VALUE;
    for (int col = 0; col < COLORS; col++) {
      min = Math.min(min, prevCostsDp[col]);
    }
    return min;
  }

}
