package linkedin.mianjing._265_Paint_House_II;

public class Solution {

  public int minCostII(int[][] costs) {
    if (costs == null || costs.length == 0) {
      return 0;
    }
    final int n = costs.length, k = costs[0].length;
    final int[][] minCosts = new int[n][k];
    System.arraycopy(costs[0], 0, minCosts[0], 0, k);
    for (int i = 1; i < n; ++i) {
      for (int j = 0; j < k; ++j) {
        int minCost = getMinCost(minCosts[i - 1], j);
        minCosts[i][j] = minCost + costs[i][j];
      }
    }
    return getMinCost(minCosts[n - 1], k + 1);
  }

  private static int getMinCost(final int[] minCost, final int j) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < minCost.length; ++i) {
      if (i != j) {
        min = Math.min(min, minCost[i]);
      }
    }
    return min;
  }
}
