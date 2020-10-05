package facebook._265_Paint_House_II;

import java.util.Arrays;

public class Solution {
  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }

    final int n = costs.length, k = costs[0].length;
    final int[] prevCost = new int[k];
    System.arraycopy(costs[0], 0, prevCost, 0, k);

    for (int row = 1; row < n; row++) {
      final int[] curCost = new int[k];
      Arrays.fill(curCost, Integer.MAX_VALUE);
      // find the min except itself
      int min = prevCost[0];
      for (int i = 1; i < k; i++) {
        curCost[i] = Math.min(curCost[i], min);
        min = Math.min(min, prevCost[i]);
      }

      min = prevCost[k - 1];
      for (int i = k - 2; i >= 0; i--) {
        curCost[i] = Math.min(curCost[i], min);
        min = Math.min(min, prevCost[i]);
      }

      for (int i = 0; i < k; i++) {
        curCost[i] += costs[row][i];
      }

      System.arraycopy(curCost, 0, prevCost, 0, k);
    }

    int min = Integer.MAX_VALUE;
    for (int num : prevCost) {
      min = Math.min(min, num);
    }
    return min;
  }
}
