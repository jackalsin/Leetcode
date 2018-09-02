package interviews.linkedin.mianjing._256_Paint_House;

public class Solution {
  public int minCost(int[][] costs) {
    final int n = costs.length;
    final int[][] minCosts = new int[n + 1][3];
    for (int i = 1; i <= n; ++i) {

      minCosts[i][0] = Math.min(minCosts[i - 1][1], minCosts[i - 1][2]) + costs[i - 1][0];
      minCosts[i][1] = Math.min(minCosts[i - 1][0], minCosts[i - 1][2]) + costs[i - 1][1];
      minCosts[i][2] = Math.min(minCosts[i - 1][0], minCosts[i - 1][1]) + costs[i - 1][2];
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      minCost = Math.min(minCost, minCosts[n][i]);
    }

    return minCost;
  }
}
